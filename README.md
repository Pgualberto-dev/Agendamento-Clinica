# 🏥 Agendamento Clínica

A console-based clinic scheduling system built in Java, focused on applying `java.time` concepts and clean object-oriented design.

---

## 📋 About

This system allows independent clinics to manage appointments through a simple terminal interface. It covers the full lifecycle of a consultation — from registering patients and available slots to scheduling and canceling appointments.

---

## ✨ Features

- **Patient registration** — auto-generated IDs with name management
- **Consultation creation** — with specialty, doctor name, date & time (with input validation)
- **Appointment scheduling** — links a patient to an available consultation
- **Appointment cancellation** — frees the consultation slot back to available
- **List consultations by day** — filter consultations by a specific date

---

## 🏗️ Project Structure

```
src/
├── entities/
│   ├── Agendamento.java   # Appointment entity (links patient + consultation)
│   ├── Clinica.java       # Core clinic entity (holds all lists)
│   ├── Consulta.java      # Consultation entity
│   └── Paciente.java      # Patient entity
├── services/
│   ├── AgendamentoServices.java  # Scheduling & cancellation logic
│   ├── ConsultaServices.java     # Consultation creation & listing
│   └── PacienteServices.java     # Patient registration logic
└── Main.java              # Entry point with menu loop
```

---

## 🛠️ Technologies

- **Java** (java.time API — `Instant`, `LocalDate`, `LocalDateTime`, `ZoneId`)
- Console I/O via `Scanner`

---

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Pgualberto-dev/Agendamento-Clinica.git
   ```

2. Open the project in your IDE (IntelliJ IDEA recommended)

3. Run `Main.java`

> **Date format:** `dd/MM/yyyy HH:mm` (e.g. `25/06/2025 14:30`)

---

## 📌 Roadmap

- [x] Console version
- [ ] Inheritance & polymorphism refactor
- [ ] Data persistence with text files
- [ ] GUI interface

---

## 👨‍💻 Author

**Pablo Gualberto**
Systems Analysis and Development — IFBA, Salvador/BA
[GitHub](https://github.com/Pgualberto-dev)
