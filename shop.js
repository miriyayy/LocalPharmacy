// Ürünleri getirmek için servis sınıfı
class ProductService {
    getProducts() {
        return axios.get("http://localhost:8080/api/products/getAll");
    }
}


const productsContainer = document.querySelector(".products");


document.querySelector('.filters').style.width = '250px';


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


// Ürünleri API'den al ve göster
const productService = new ProductService();
productService.getProducts()
    .then(response => {
        allProducts = response.data.data; // API'den alınan ürünler
        displayProducts(allProducts); // İlk durumda tüm ürünleri göster
    })
    .catch(error => console.error("Error fetching products:", error));




    // Kategorilere olay dinleyicileri ekleme
const categoryLinks = document.querySelectorAll("nav a");

categoryLinks.forEach(link => {
    link.addEventListener("click", event => {
        event.preventDefault(); // Sayfanın yeniden yüklenmesini engelle
        const categoryName = link.textContent.trim(); // Tıklanan kategori adı (boşlukları temizle)
        
        if (categoryName === "All Products") {
            // Tüm ürünleri göster
            displayProducts(allProducts);
        } else {
            // Filtrelenmiş ürünleri göster
            const filteredProducts = allProducts.filter(product => product.category.categoryName === categoryName);
            displayProducts(filteredProducts);
        }
    });
});

// Fiyat aralığı filtreleme
const filterCheckboxes = document.querySelectorAll('aside.filters input[type="checkbox"]');
const minPriceInput = document.getElementById("min-price");
const maxPriceInput = document.getElementById("max-price");
const applyFiltersButton = document.getElementById("apply-filters");

applyFiltersButton.addEventListener("click", () => {
    const minPrice = parseFloat(minPriceInput.value) || 0; // Boşsa 0 al
    const maxPrice = parseFloat(maxPriceInput.value) || Infinity; // Boşsa sonsuz al

    const filteredProducts = allProducts.filter(product => 
        product.unitPrice >= minPrice && product.unitPrice <= maxPrice
    );

    displayProducts(filteredProducts); // Filtrelenen ürünleri göster
});

filterCheckboxes.forEach(checkbox => {
    checkbox.addEventListener("change", () => {
        const selectedPrices = Array.from(filterCheckboxes)
            .filter(checkbox => checkbox.checked)
            .map(checkbox => checkbox.value.split("-").map(Number)); // "100-200" => [100, 200]

        const filteredProducts = allProducts.filter(product => {
            return selectedPrices.some(([min, max]) => 
                product.unitPrice >= min && product.unitPrice <= max
            );
        });

        displayProducts(filteredProducts); // Filtrelenen ürünleri göster
    });
});
