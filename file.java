let users = []; // Halkaan ayaa lagu keydinayaa isticmaale yaasha

const form = document.getElementById("form");
const emailInput = document.getElementById("email");
const passwordInput = document.getElementById("password");
const submitBtn = document.getElementById("submit-btn");
const toggleBtn = document.getElementById("toggle-btn");
const toggleText = document.getElementById("toggle-text");
const formTitle = document.getElementById("form-title");
const message = document.getElementById("message");

let isSignUp = false;

toggleBtn.addEventListener("click", () => {
    isSignUp = !isSignUp;
    formTitle.textContent = isSignUp ? "Sign Up" : "Login";
    toggleText.textContent = isSignUp
        ? "Already have an account?"
        : "Don't have an account?";
    submitBtn.textContent = isSignUp ? "Sign Up" : "Login";
    message.textContent = "";
});

submitBtn.addEventListener("click", () => {
    const email = emailInput.value.trim();
    const password = passwordInput.value.trim();

    if (email === "" || password === "") {
        message.textContent = "Please fill in all fields.";
        return;
    }

    if (isSignUp) {
        // Diiwaan Gelin
        const userExists = users.some((user) => user.email === email);
        if (userExists) {
            message.textContent = "Account already exists.";
        } else {
            users.push({ email, password });
            message.style.color = "green";
            message.textContent = "Account created successfully!";
        }
    } else {
        // Login
        const user = users.find((user) => user.email === email && user.password === password);
        if (user) {
            message.style.color = "green";
            message.textContent = "Login successful!";
        } else {
            message.style.color = "red";
            message.textContent = "Account not found. Please sign up.";
        }
    }
    emailInput.value = "";
    passwordInput.value = "";
});