document.addEventListener("DOMContentLoaded", () => {
    const swiperWrapper = document.getElementById('swiper_articles');

    fetch('/api/v1/article') // путь к JSON на сервере
        .then(response => response.json())
        .then(data => {
            data.forEach(article => {
                const slide = document.createElement("div");
                slide.classList.add("swiper-slide");

                slide.innerHTML = `
                    <img src="${article.image_path}" alt="">
                    <div class="articl_slide_text">
                        <h2>${article.name}</h2>
                        <p>${article.description}</p>
                        <h1><a href="${article.link}">Читать дальше</a></h1>
                    </div>
                `;

                swiperWrapper.appendChild(slide);
            });

            if (window.swiperArticles) {
                window.swiperArticles.update();
            }


        })
        .catch(error => console.error("Ошибка загрузки JSON:", error));
});