const reviews = document.querySelectorAll('.review');
const dots = document.querySelectorAll('.dot');
const prev = document.querySelector('.prev');
const next = document.querySelector('.next');

let index = 0;

function showReview(i) {
  reviews.forEach(r => r.classList.remove('active'));
  dots.forEach(d => d.classList.remove('active'));

  reviews[i].classList.add('active');
  dots[i].classList.add('active');
}

function nextReview() {
  index = (index + 1) % reviews.length;
  showReview(index);
}

function prevReview() {
  index = (index - 1 + reviews.length) % reviews.length;
  showReview(index);
}

dots.forEach((dot, i) => {
  dot.addEventListener('click', () => {
    index = i;
    showReview(index);
  });
});

next.addEventListener('click', nextReview);
prev.addEventListener('click', prevReview);

// Автопереключение
setInterval(nextReview, 5000);
