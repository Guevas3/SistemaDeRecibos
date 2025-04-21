<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">  
</head>
<body>

  <h1>Guía de Inicio del Proyecto</h1>

  <h2>✅ Requisitos Previos</h2>
  <ul>
    <li>JDK 17</li>
    <li>NetBeans 17</li>
    <li>XAMPP</li>
    <li>MySQL Workbench</li>
    <li>MySQL Connector 8.0.17</li>
  </ul>

  <h2>⚙️ Pasos Previos al Ejecución del Proyecto</h2>

  <div class="step">
    <h3>1. Levantar puertos de MySQL en XAMPP</h3>
    <img src="https://github.com/user-attachments/assets/2e4da6a9-dbec-402c-aa79-5cb983c5b112" alt="XAMPP - MySQL">
  </div>

  <div class="step">
    <h3>2. Crear una nueva conexión en MySQL Workbench</h3>
    <p class="highlight">Abrir MySQL Workbench y configurar una nueva conexión con los parámetros mostrados:</p>
    <img src="https://github.com/user-attachments/assets/b9f6134d-acc5-473e-a15b-a334997f74f9" alt="Conexión Workbench">
  </div>

  <div class="step">
    <h3>3. Abrir el proyecto en NetBeans</h3>
    <ul>
      <li>Abrir NetBeans.</li>
      <li>Abrir el proyecto existente.</li>
      <li>Ir al apartado <strong>Servicios</strong>.</li>
      <li>Conectar la base de datos creada en el paso anterior.</li>
    </ul>
    <img src="https://github.com/user-attachments/assets/fb6c07a7-e783-478d-9ced-7f3d346a47a3" alt="Servicios - NetBeans">
    <img src="https://github.com/user-attachments/assets/38a7e6d1-220d-4055-8e2b-fecb53e246ef" alt="Base de datos en NetBeans">
    <p class="highlight">Dejar los parámetros tal cual como se muestra:</p>
    <img src="https://github.com/user-attachments/assets/bf96c420-a7f9-48e0-961c-08cb9492fe3a" alt="Parámetros de conexión">
  </div>

  <div class="step">
    <h3>4. Compilar y correr el proyecto</h3>
    <ul>
      <li>Haz clic derecho sobre el proyecto.</li>
      <li>Selecciona <strong>Clean and Build</strong>.</li>
      <li>Corre el proyecto.</li>
    </ul>
    <p>¡Se abrirá una ventana Swing con la interfaz para crear un recibo!</p>
    <img src="https://github.com/user-attachments/assets/abc6042d-85eb-41d4-a374-d30c59303f97" alt="Interfaz de usuario - Recibo">
  </div>

</body>
</html>
