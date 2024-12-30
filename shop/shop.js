class ProductService {
    getProducts() {
        return axios.get("http://localhost:8080/api/products/getAll");
    }
}

const productsContainer = document.querySelector(".products");


function displayProducts(products) {
    productsContainer.innerHTML = "";
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


const productService = new ProductService();
productService.getProducts()
    .then(response => {
        displayProducts(response.data.data);
    })
    .catch(error => console.error("Error fetching products:", error));
