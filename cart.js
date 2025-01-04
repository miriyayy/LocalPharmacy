// Sepet ürünlerini localStorage'dan al 
function getCartItems() {
    return JSON.parse(localStorage.getItem("cart")) || [];
}

// Sepet ürünlerini görüntüle
function displayCartItems() {
    const cartItems = getCartItems();
    const cartContainer = document.querySelector(".container .row");

    cartContainer.innerHTML = ""; // Önceki içerikleri temizle
    if (cartItems.length === 0) {
        cartContainer.innerHTML = "<p>No items in cart.</p>";
        return;
    }

    cartItems.forEach(item => {
        const cartItemHTML = `
            <div class="col-md-6 mb-4">
                <div class="card">
                    <img src="${item.imageUrl}" class="card-img-top" alt="${item.productName}">
                    <div class="card-body">
                        <h5 class="card-title">${item.productName}</h5>
                        <p class="card-text">Category: ${item.category.categoryName}</p>
                        <p class="card-text">Price: ${item.unitPrice}₺</p>
                        <button class="btn btn-danger remove-from-cart" data-id="${item.id}">Remove</button>
                    </div>
                </div>
            </div>
        `;
        cartContainer.innerHTML += cartItemHTML;
    });

    // Remove item from cart event
    document.querySelectorAll(".remove-from-cart").forEach(button => {
        button.addEventListener("click", event => {
            const productId = event.target.getAttribute("data-id");
            removeItemFromCart(productId);
            displayCartItems(); // Güncellenmiş sepeti tekrar göster
        });
    });

    // Place Order Button
    const placeOrderButton = document.createElement("button");
    placeOrderButton.textContent = "Place Order";
    placeOrderButton.className = "btn btn-success place-order mt-4";
    placeOrderButton.addEventListener("click", () => {
        clearCart();
        cartContainer.innerHTML = "<p class='order-confirmation'>Your order has been placed</p>";
    });
    cartContainer.appendChild(placeOrderButton);
}

// Ürünü sepetten kaldır
function removeItemFromCart(productId) {
    let cart = getCartItems();
    cart = cart.filter(item => item.id !== parseInt(productId));
    localStorage.setItem("cart", JSON.stringify(cart)); // Güncel sepeti kaydet
}

// Sepeti temizle
function clearCart() {
    localStorage.removeItem("cart");
}

// Sayfa yüklendiğinde ürünleri görüntüle
document.addEventListener("DOMContentLoaded", () => {
    displayCartItems();
});
