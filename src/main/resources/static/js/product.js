document.addEventListener("DOMContentLoaded", () => {
    const swiperWrapper = document.getElementById('product');
    fetch('/api/v1/apteka/getAll') // путь к JSON на сервере
        .then(response => response.json())
        .then(data => {
            data.forEach(product => {
                if(product.on_main){
                const slide = document.createElement("div");
                slide.classList.add("apteka_card");
                slide.innerHTML = `
                    <img class="apteka_img" src="${product.image_path}" alt="">
                    <h3>${product.name}</h3>
                    <p>${product.description}</p>
                    <h1>${product.price}</h1>
                `;

                swiperWrapper.appendChild(slide);
                }
            });
        })
        .catch(error => console.error("Ошибка загрузки JSON:", error));
});