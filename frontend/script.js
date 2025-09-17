// Toggle login/register
let isLogin = true;
const toggleText = document.getElementById("toggle-text");
if (toggleText) {
  toggleText.addEventListener("click", () => {
    isLogin = !isLogin;
    document.getElementById("form-title").textContent = isLogin ? "Login" : "Register";
    document.getElementById("submit-btn").textContent = isLogin ? "Login" : "Register";
    document.getElementById("extra-fields").style.display = isLogin ? "none" : "block";
    toggleText.innerHTML = isLogin
      ? `Don’t have an account? <span id="toggle-link">Create one</span>`
      : `Already have an account? <span id="toggle-link">Login</span>`;
  });
}

// Login/Register handler
const authForm = document.getElementById("auth-form");
if (authForm) {
  authForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const username = document.getElementById("username").value;
    alert(`🔑 Welcome ${username}`);
    window.location.href = "dashboard.html"; 
  });
}

// Switch pages
function showPage(pageId) {
  document.querySelectorAll(".page").forEach(p => p.classList.add("hidden"));
  document.getElementById(pageId).classList.remove("hidden");
}

// Food log
function addFood() {
  const name = document.getElementById("food-name").value;
  const cal = document.getElementById("food-calories").value;
  if (name && cal) {
    document.getElementById("food-list").innerHTML += `<li>${name} - ${cal} cal</li>`;
    document.getElementById("food-name").value = "";
    document.getElementById("food-calories").value = "";
  }
}

// Sleep log
function logSleep() {
  const hours = document.getElementById("sleep-hours").value;
  if (hours) {
    document.getElementById("sleep-list").innerHTML += `<li>${hours} hours</li>`;
    document.getElementById("sleep-hours").value = "";
  }
}

// Exercise log
function logExercise() {
  const ex = document.getElementById("exercise-name").value;
  const dur = document.getElementById("exercise-duration").value;
  if (ex && dur) {
    document.getElementById("exercise-list").innerHTML += `<li>${ex} - ${dur} min</li>`;
    document.getElementById("exercise-name").value = "";
    document.getElementById("exercise-duration").value = "";
  }
}

// Goals
function setGoal() {
  const type = document.getElementById("goalType").value;
  const target = document.getElementById("targetCalories").value;
  if (target) {
    document.getElementById("goal-list").innerHTML = `<li>🎯 ${type} | ${target} cal/day</li>`;
  }
}

// Summary
function getSummary() {
  const foodItems = document.querySelectorAll("#food-list li");
  const exerciseItems = document.querySelectorAll("#exercise-list li");
  const sleepItems = document.querySelectorAll("#sleep-list li");
  const goal = document.querySelector("#goal-list li")?.innerText || "No goal set";

  let foodSummary = [...foodItems].map(li => li.innerText).join("<br>");
  let exerciseSummary = [...exerciseItems].map(li => li.innerText).join("<br>");
  let sleepSummary = [...sleepItems].map(li => li.innerText).join("<br>");

  document.getElementById("summaryOutput").innerHTML = `
    <strong>Food:</strong><br>${foodSummary || "No food logged"}<br><br>
    <strong>Exercise:</strong><br>${exerciseSummary || "No exercise logged"}<br><br>
    <strong>Sleep:</strong><br>${sleepSummary || "No sleep logged"}<br><br>
    <strong>Goal:</strong><br>${goal}
  `;
  showPage("summary");
}

function logout() {
  window.location.href = "index.html";
}

function loadSummary() {
  let foods = JSON.parse(localStorage.getItem("foods")) || [];
  let sleeps = JSON.parse(localStorage.getItem("sleeps")) || [];
  let exercises = JSON.parse(localStorage.getItem("exercises")) || [];

  let totalCalories = foods.reduce((sum, f) => sum + (parseInt(f.calories) || 0), 0);
  let totalSleep = sleeps.reduce((sum, s) => sum + (parseInt(s.hours) || 0), 0);
  let totalExercise = exercises.reduce((sum, e) => sum + (parseInt(e.minutes) || 0), 0);

  let summaryHTML = `
    <h3>Today’s Summary</h3>
    <p><b>Total Calories Consumed:</b> ${totalCalories} kcal</p>
    <p><b>Total Sleep:</b> ${totalSleep} hours</p>
    <p><b>Total Exercise:</b> ${totalExercise} minutes</p>
  `;

  document.getElementById("summary-content").innerHTML = summaryHTML;
}

// Jab bhi summary page open ho, load karna
document.querySelector("button[data-page='summary']").addEventListener("click", loadSummary);

