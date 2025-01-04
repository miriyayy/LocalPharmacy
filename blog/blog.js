// Blog.js

// Filter Categories
const categoryButtons = document.querySelectorAll('.category-btn');
const blogCards = document.querySelectorAll('.blog-card');

categoryButtons.forEach(button => {
    button.addEventListener('click', () => {
        const category = button.textContent.toLowerCase();

        // Blog kartlarını filtrele
        blogCards.forEach(card => {
            if (category === 'tümü' || card.textContent.toLowerCase().includes(category)) {
                card.style.display = 'block';
            } else {
                card.style.display = 'none';
            }
        });

        // Aktif butonu işaretle
        categoryButtons.forEach(btn => btn.classList.remove('active'));
        button.classList.add('active');
    });
});
