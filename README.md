# ✅ Serenity BDD Automation Framework

Framework de automatización funcional construido con:

- ✅ Serenity BDD
- ✅ Cucumber con JUnit 5 (`cucumber-junit-platform-engine`)
- ✅ WebDriverManager (Bonigarcia)
- ✅ SLF4J para logging
- ✅ Java 17
- ✅ Page Object Model (POM)
- ✅ Reportes HTML y JSON de Cucumber y Serenity

---

## 📂 Estructura del Proyecto

```
    src
    └── test
    ├── java
    │ └── com.example.automation
    │ ├── hooks
    │ ├── pages
    │ ├── runners
    │ ├── stepdefinitions
    │ ├── steps
    │ └── utils
    └── resources
    ├── features
    ├── serenity.conf
    └── junit-platform.properties
```

---

## 🚀 Cómo ejecutar el proyecto

### 🔧 1. Clonar el repositorio

```bash
    git clone
```

###  🧪 2. Instalar dependencias

```bash
    mvn clean install
```

### 🧪 3. Ejecutar pruebas (todos los escenarios)

```bash
    mvn clean verify
```

### 🧪 4. Ejecutar pruebas (escenario específico)

```bash
    mvn clean verify -Dcucumber.filter.tags="@tag"
```
---

##  🏷️ 4. Ejecutar pruebas por tag en junit-platform.properties

### ➤ Paso 1: Asegúrate de que el tag esté en tu feature file
```gherkin
@login
Scenario: Successful login
```

### ➤ Paso 2: Configura el tag en `junit-platform.properties`
###  -  Ubicado en src/test/resources/junit-platform.properties:
```properties
cucumber.filter.tags=@login
```
```textPlain
También puedes usar combinaciones:
(@login or @smoke)
(@login and not @skip)
```
### ➤ Paso 3: Ejecuta las pruebas
```bash
    mvn clean verify
```
---
## 📝 5. Ver reportes

Los reportes se generan automáticamente en el directorio

`target/site/serenity` y `target/cucumber-reports`.

## 🛠️ Generar reportes nuevamente sin correr pruebas

```bash
    mvn serenity:aggregate
```
---
## 🧩 6. Comandos utiles

| Comando                  | Descripción                    |
| ------------------------ | ------------------------------ |
| `mvn clean verify`       | Ejecuta todas las pruebas      |
| `mvn serenity:aggregate` | Solo genera reportes           |
| `mvn clean`              | Limpia el directorio `target/` |


---

## 🧠 Detalles importantes:

  1.  **@Suite:** activa el motor de JUnit 5.

  2. __@IncludeEngines("cucumber"):__ indica que se usará Cucumber.

  3. **@SelectClasspathResource("features"):** apunta a la carpeta donde están tus .feature, dentro de src/test/resources/features.

  4. **GLUE_PROPERTY_NAME:** el paquete donde están tus definiciones (@Given, @When, etc.).

  5. **PLUGIN_PROPERTY_NAME:** genera el .json que Serenity necesita para construir el reporte.

---

 ## 📚 Notas
- Asegúrate de tener configurado el `JAVA_HOME` correctamente.
- El navegador por defecto es Chrome. Puedes cambiarlo desde serenity.conf.
- El driver se gestiona automáticamente con WebDriverManager.
- Los reportes de Cucumber y Serenity se generan en formato HTML y JSON.
- Puedes personalizar los reportes editando `serenity.conf`.
- Los hooks (@Before, @After) están definidos para iniciar y cerrar el navegador por cada escenario.
- Los pasos de Cucumber están organizados en clases separadas para mantener el código limpio y modular.
- Los escenarios de Cucumber están escritos en Gherkin para facilitar la comprensión y colaboración con el equipo.
- El proyecto sigue el patrón Page Object Model (POM) para una mejor organización de las páginas y elementos de la UI.
- Los runners de Cucumber están configurados para usar JUnit 5 y Serenity BDD.
- Los archivos de configuración de Serenity y JUnit Platform están ubicados en `src/test/resources`.
- Puedes agregar más tags en tus archivos de características para filtrar pruebas específicas.
- Los reportes incluyen capturas de pantalla y logs de cada paso ejecutado.
- El proyecto está diseñado para ser fácilmente extensible y mantenible.
- Puedes agregar más hooks, pasos y páginas según sea necesario.
- El proyecto es compatible con múltiples navegadores, pero el enfoque principal es Chrome.
- Puedes ejecutar pruebas en paralelo configurando `serenity.conf` adecuadamente.
- El proyecto está optimizado para ser ejecutado en entornos CI/CD como Jenkins, GitHub Actions, etc.
- Asegúrate de revisar los logs en caso de fallos para identificar problemas rápidamente.
---
# Gracias por usar este framework de automatización con Serenity BDD y Cucumber. ¡Feliz automatización! 🚀

