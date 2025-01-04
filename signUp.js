document.addEventListener("DOMContentLoaded", () => {
  const signUpForm = document.querySelector("form");
  signUpForm.addEventListener("submit", async (event) => {
    event.preventDefault();

    const email = signUpForm.querySelector('input[placeholder="Email or Phone"]').value;
    const password = signUpForm.querySelector('input[placeholder="Password"]').value;
    const rePassword = signUpForm.querySelector('input[placeholder="Re-Password"]').value;

    if (password !== rePassword) {
      alert("Passwords do not match!");
      return;
    }

    try {
      const response = await fetch("http://localhost:8080/api/users/addUser", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ email, password }),
      });

      if (response.ok) {
        alert("Sign up successful!");
        window.location.href = "log.html"; // Login sayfasına yönlendirme
      } else {
        alert("Sign up failed!");
      }
    } catch (error) {
      alert("Network error!");
      console.error(error);
    }
  });
});
