document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.querySelector("form");
    loginForm.addEventListener("submit", async (event) => {
      event.preventDefault();
  
      const email = loginForm.querySelector('input[placeholder="Email or Phone"]').value;
      const password = loginForm.querySelector('input[placeholder="Password"]').value;
  
      const response = await fetch("http://localhost:8080/api/users/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ email, password }),
      });
  
      if (response.ok) {
        alert("Login successful!");
        window.location.href = "index.html"; // Yönlendirme
      } else {
        alert("Invalid credentials!");
      }
    });
  });
  