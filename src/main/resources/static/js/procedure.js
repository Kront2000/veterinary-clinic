


    async function loadProcedures() {
        try {
            const response = await fetch("/api/v1/procedures");
            if (!response.ok) {
                throw new Error("Ошибка загрузки данных");
            }

            const data = await response.json();
            const container = document.getElementById("proceduresContainer");

            // Достаём все процедуры с on_main = true
            let mainProcedures = data.flatMap(cat =>
                cat.procedures.map(p => ({...p, category_image: cat.image_path}))
            ).filter(p => p.on_main);

            // Перемешиваем массив (рандом)
            mainProcedures = mainProcedures.sort(() => Math.random() - 0.5);

            // Берём только 4 процедуры
            mainProcedures.slice(0, 4).forEach(proc => {
                const card = document.createElement("div");
                card.classList.add("procedure_card");

                card.innerHTML = `
                    <img src="${proc.category_image}" class="procedures_card_img" alt="${proc.name}">
                    <div class="line"></div>
                    <div class="procedure_card_text">
                        <h3>${proc.name}</h3>
                        <p>${proc.price}тг</p>
                    </div>
                `;

                container.appendChild(card);
            });
        } catch (error) {
            console.error("Ошибка:", error);
        }
    }

    loadProcedures();

