// Ürünleri getirmek için servis sınıfı
class ProductService {
    getProducts() {
        return axios.get("http://localhost:8080/api/products/getAll");
    }
}

// HTML öğeleri seçiliyor
const productsContainer = document.querySelector(".products");
const applyFiltersButton = document.getElementById("apply-filters");
const navbarLinks = document.querySelectorAll("nav a");
const minPriceInput = document.getElementById("min-price");
const maxPriceInput = document.getElementById("max-price");

// Kullanıcı seçimini izlemek için değişkenler
let selectedCategory = "All Products"; // Varsayılan kategori
let allProducts = []; // API'den alınan tüm ürünler burada saklanacak

// Ürünleri görüntüleme fonksiyonu
function displayProducts(products) {
    productsContainer.innerHTML = ""; // Önceki ürünleri temizle
    if (products.length === 0) {
        productsContainer.innerHTML = "<p>No products found.</p>";
        return;
    }
    products.forEach(product => {
        const productCard = `
            <div class="product-card">
                <img src="${product.imageUrl}" alt="${product.productName}" class="product-image">
                <h3>${product.productName}</h3>
                <p>${product.category.categoryName}</p>
                <p class="price">${product.unitPrice}₺</p>
                <button class="add-to-cart">Add to Cart</button>
            </div>
        `;
        productsContainer.innerHTML += productCard;
    });
}

// Filtreleme fonksiyonu
function applyFilters() {
    const minPrice = parseFloat(minPriceInput.value) || 0; // Fiyat aralığının minimum değeri
    const maxPrice = parseFloat(maxPriceInput.value) || Infinity; // Fiyat aralığının maksimum değeri

    // Seçilen kategoriye ve fiyat aralığına göre filtreleme
    const filteredProducts = allProducts.filter(product => {
        const matchesCategory =
            selectedCategory === "All Products" || // "All Products" seçildiyse tüm ürünleri göster
            product.category.categoryName === selectedCategory;
        const matchesPrice = product.unitPrice >= minPrice && product.unitPrice <= maxPrice; // Fiyat kontrolü
        return matchesCategory && matchesPrice; // Hem kategoriye hem de fiyat aralığına uyan ürünler
    });

    displayProducts(filteredProducts); // Filtrelenen ürünleri göster
}

// Navbar tıklama olaylarını dinle
navbarLinks.forEach(link => {
    link.addEventListener("click", (event) => {
        event.preventDefault(); // Sayfa yenilenmesini önle
        selectedCategory = event.target.textContent; // Tıklanan kategori
        applyFilters(); // Filtreleri uygula ve göster

        // Aktif sınıfını güncelle
        navbarLinks.forEach(nav => nav.classList.remove("active"));
        event.target.classList.add("active");
    });
});

// Fiyat filtresi düğmesine tıklama
applyFiltersButton.addEventListener("click", () => {
    applyFilters(); // Fiyat aralığına göre filtrele
});

// Ürünleri API'den al ve göster
const productService = new ProductService();
productService.getProducts()
    .then(response => {
        allProducts = response.data.data; // API'den alınan ürünler
        displayProducts(allProducts); // İlk durumda tüm ürünleri göster
    })
    .catch(error => console.error("Error fetching products:", error));
