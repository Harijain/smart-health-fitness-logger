const API = "http://localhost:8080/api";
let userId = localStorage.getItem("userId") || null;

function showPage(pageId) {
  document.querySelectorAll(".page").forEach(p => p.classList.add("hidden"));
  document.getElementById(pageId).classList.remove("hidden");
}

// Utility: show success or error messages
function showMessage(message, type = "success") {
  const msgBox = document.createElement("div");
  msgBox.className = `msg ${type}`;
  msgBox.innerText = message;

  document.body.appendChild(msgBox);
  setTimeout(() => msgBox.remove(), 3000);
}

// Register User
async function registerUser() {
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;

  try {
    const res = await fetch(`${API}/users`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name, email })
    });

    if (!res.ok) {
      const err = await res.text();
      throw new Error(err || "Request failed");
    }

    const data = await res.json();
    alert("User created: " + data.id);
    userId = data.id;
    localStorage.setItem("userId", userId);
  } catch (e) {
    console.error("Registration failed:", e);
    alert("Registration failed: " + e.message);
  }
}


// Add Food
async function addFood() {
  const name = document.getElementById("foodName").value;
  const calories = document.getElementById("calories").value;

  try {
    const res = await fetch(`${API}/foods`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ userId, name, calories: Number(calories) })
    });
    const data = await res.json();
    showMessage(`🍎 Food added: ${data.name} (${data.calories} cal)`);
    document.getElementById("foodName").value = "";
    document.getElementById("calories").value = "";
  } catch {
    showMessage("Error adding food ❌", "error");
  }
}

// Add Exercise
async function addExercise() {
  const name = document.getElementById("exerciseName").value;
  const caloriesBurned = document.getElementById("burned").value;

  try {
    const res = await fetch(`${API}/exercises`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ userId, name, caloriesBurned: Number(caloriesBurned) })
    });
    const data = await res.json();
    showMessage(`🏋️ Exercise added: ${data.name} (-${data.caloriesBurned} cal)`);
    document.getElementById("exerciseName").value = "";
    document.getElementById("burned").value = "";
  } catch {
    showMessage("Error adding exercise ❌", "error");
  }
}

// Add Sleep
async function addSleep() {
  const hours = document.getElementById("hours").value;

  try {
    const res = await fetch(`${API}/sleeps`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ userId, hours: Number(hours) })
    });
    const data = await res.json();
    showMessage(`😴 Sleep logged: ${data.hours} hrs`);
    document.getElementById("hours").value = "";
  } catch {
    showMessage("Error logging sleep ❌", "error");
  }
}

// Set Goal
async function setGoal() {
  const goalType = document.getElementById("goalType").value;
  const targetCalories = document.getElementById("targetCalories").value;

  try {
    const res = await fetch(`${API}/goals`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ userId, goalType, targetCalories: Number(targetCalories) })
    });
    const data = await res.json();
    showMessage(`🎯 Goal set: ${data.goalType} (${data.targetCalories} cal)`);
    document.getElementById("targetCalories").value = "";
  } catch {
    showMessage("Error setting goal ❌", "error");
  }
}

// Get Summary
async function getSummary() {
  try {
    const res = await fetch(`${API}/summary/${userId}`);
    const data = await res.json();

    // Format output nicely
    document.getElementById("summaryOutput").innerHTML = `
      <div class="card">🍎 Food Calories: <b>${data.totalFoodCalories}</b></div>
      <div class="card">🏋️ Burned: <b>${data.totalExerciseCalories}</b></div>
      <div class="card">😴 Sleep Hours: <b>${data.totalSleepHours}</b></div>
      <div class="card">🎯 Goal: <b>${data.goal?.goalType || "N/A"}</b> (${data.goal?.targetCalories || 0} cal)</div>
      <div class="card">⚖️ Net: <b>${data.netCalories}</b></div>
    `;
  } catch {
    showMessage("Error fetching summary ❌", "error");
  }
}
