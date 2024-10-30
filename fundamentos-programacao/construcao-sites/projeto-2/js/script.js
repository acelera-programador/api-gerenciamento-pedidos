document.addEventListener('DOMContentLoaded', function() {
  const mostrarMaisBtn = document.getElementById('mostrarMais');
  const textoAdicional = document.getElementById('textoAdicional');

  mostrarMaisBtn.addEventListener('click', function() {
      if (textoAdicional.style.display === 'none') {
          textoAdicional.style.display = 'block';
          mostrarMaisBtn.textContent = 'Mostrar Menos';
      } else {
          textoAdicional.style.display = 'none';
          mostrarMaisBtn.textContent = 'Mostrar Mais';
      }
  });

  const detalhesBtns = document.querySelectorAll('.detalhes');
  detalhesBtns.forEach(function(btn) {
      btn.addEventListener('click', function() {
          alert('Detalhes do projeto em breve!');
      });
  });

  const formContato = document.getElementById('formContato');
  formContato.addEventListener('submit', function(event) {
      event.preventDefault();
      alert('Obrigado por entrar em contato! Entraremos em breve em contato com você.');
      formContato.reset();
  });
});
