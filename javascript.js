/*---SHOP----*/
// Favori butonunu kontrol etme
const favoriteButtons = document.querySelectorAll('.favorite-btn');
favoriteButtons.forEach(button => {
    button.addEventListener('click', () => {
        button.classList.toggle('favorited');
        if (button.classList.contains('favorited')) {
            button.textContent = '❤️'; // Favori ekli
        } else {
            button.textContent = '♥'; // Favori çıkarıldı
        }
    });
});

// Sepete ekleme
const cartButtons = document.querySelectorAll('.add-to-cart');
cartButtons.forEach(button => {
    button.addEventListener('click', () => {
        alert("Ürün sepete eklendi!");
    });
});
