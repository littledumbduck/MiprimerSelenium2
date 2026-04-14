# 🧪 Automatización de Login con Selenium y JUnit 5

Este proyecto contiene la automatización de pruebas para el portal de prácticas **SauceDemo**. Se ha implementado utilizando Java y el patrón de diseño **Page Object Model (POM)** para garantizar un código limpio y mantenible.

## 📁 Estructura del Proyecto

A continuación se detalla la organización de los archivos principales del ejercicio:

```MiprimerSelenium2-master/
├── pom.xml                 # Configuración de Maven y dependencias
└── src/
    └── test/
        └── java/
            ├── pages/
            │   └── LoginPage.java    # Clase Page Object (Lógica de la página)
            └── test/
                └── LoginTest.java    # Clases de prueba (JUnit 5)
```


# 🛠️ Tecnologías Utilizadas
Java 25: Lenguaje de programación.

Selenium WebDriver (4.42.0): Para la automatización de acciones en el navegador.

JUnit 5: Framework para la ejecución de pruebas y aserciones.

WebDriverManager: Para la gestión automática de los drivers de Chrome.

# 🚀 Funcionalidades Implementadas
1. LoginPage (Page Object Model)
Se ha creado la clase pages.LoginPage que encapsula la interacción con la web:

- Localización de elementos mediante By.id.
- Métodos para ingresar usuario, contraseña y hacer clic.
- Mejora: Método login(user, pass) que realiza el flujo completo en una sola línea.

2. Casos de Prueba
En test.LoginTest, se ejecutan los siguientes escenarios:

- loginCorrecto: Verifica que un usuario válido entra a la sección "inventory".

- loginIncorrecto: Valida que credenciales erróneas no permitan el acceso (usando assertFalse).

- loginCorrecto2: Versión optimizada del test usando el método combinado de la clase Page.

- Se han incluido pausas de Thread.sleep(2000) para permitir la observación visual de los pasos en el navegador durante la ejecución.

# 📝 Cuestiones Resueltas
- ¿Qué hace la anotación @BeforeEach?

Ejecuta el código de configuración (inicializar driver, abrir URL) antes de cada uno de los tests para asegurar un estado limpio.
- ¿Para qué sirve assertTrue?

Para validar que una condición se cumple. Si la condición dentro del paréntesis es falsa, el test fallará automáticamente.

- ¿Qué diferencia hay entre findElement() y findElements()?

findElement() busca un solo elemento y lanza error si no lo halla. findElements() busca todos los que coincidan y devuelve una lista (vacía si no encuentra nada).

- ¿Por qué utilizamos una clase LoginPage en lugar de escribir todo en el test?

Para separar la lógica de la interfaz de la lógica de la prueba. Esto facilita el mantenimiento: si el diseño de la web cambia, solo editamos la clase Page y los tests siguen funcionando.
