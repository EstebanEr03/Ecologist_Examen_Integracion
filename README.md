# 🚚 EcoLogistics S.A. - Sistema de Integración# EcoLogistics Integration System# 🐪 Apache Camel - File Transfer Integration Project



Sistema de integración empresarial que moderniza el proceso de gestión de envíos desde archivos CSV hacia una solución basada en APIs RESTful utilizando Apache Camel y Spring Boot.



## 📋 Tabla de ContenidosSistema de integración para modernizar el ecosistema tecnológico de EcoLogistics S.A., empresa de transporte y distribución.## Descripción



- [Descripción](#descripción)Proyecto de integración de sistemas utilizando **Apache Camel** con **Spring Boot** que implementa el patrón **File Transfer** para procesar archivos CSV con transformaciones automáticas.

- [Características](#características)

- [Tecnologías](#tecnologías)## Descripción del Proyecto

- [Requisitos Previos](#requisitos-previos)

- [Instalación](#instalación)## 🚀 Tecnologías Utilizadas

- [Ejecución](#ejecución)

- [Endpoints de la API](#endpoints-de-la-api)EcoLogistics S.A. busca reemplazar su sistema tradicional de envío de archivos CSV por correo electrónico con una solución moderna basada en APIs RESTful, aplicando patrones clásicos de integración con Apache Camel.- **Java 21** (LTS)

- [Pruebas](#pruebas)

- [Docker](#docker)- **Spring Boot 3.5.7**

- [Estructura del Proyecto](#estructura-del-proyecto)

### Problemática Actual- **Apache Camel 4.14.0**

## 📖 Descripción

- Manejo manual y descentralizado de información de envíos y vehículos- **Gradle 8.14.3**

EcoLogistics S.A. es una empresa de transporte y distribución que moderniza su ecosistema tecnológico. Este proyecto implementa un prototipo funcional que demuestra cómo una solución moderna basada en APIs RESTful puede reemplazar el mecanismo tradicional de envío de archivos CSV por correo electrónico.

- Supervisores envían archivos CSV por correo electrónico diariamente- **Enterprise Integration Patterns (EIP)**

### Problema

- Gestión manual y descentralizada de envíos- Falta de integración y automatización en los procesos

- Supervisores envían archivos CSV diariamente por email

- Falta de integración en tiempo real## 📋 Características Principales

- Procesos ineficientes

### Solución Propuesta

### Solución

- API REST moderna con documentación OpenAPI- API REST moderna para gestión de envíos y vehículos### ✨ Funcionalidades Implementadas

- Carga automática de archivos CSV (patrón File Transfer)

- Transformación CSV → JSON estandarizado- Procesamiento automático de archivos CSV- 📁 **Procesamiento automático** de archivos CSV

- Endpoints para consulta y gestión de envíos

- Integración con Apache Camel y patrones de integración empresarial- 🔄 **Transformación de contenido** a mayúsculas

## ✨ Características

- Documentación OpenAPI completa- 📊 **Filtrado por tipo de archivo** (.csv)

- ✅ **Patrón File Transfer**: Carga automática de `envios.csv`

- ✅ **Transformación de datos**: Conversión CSV a JSON estandarizado- 💾 **Archivado con timestamp** para auditoría

- ✅ **API REST completa**: 3 endpoints principales + health check

- ✅ **Documentación OpenAPI**: Especificación Swagger disponible## Arquitectura del Sistema- 📝 **Logging detallado** con fecha y hora

- ✅ **Logs detallados**: Trazabilidad completa de operaciones

- ✅ **ID automático**: Generación de identificadores para nuevos envíos- 👁️ **Monitoreo de archivos** de log

- ✅ **Health Check**: Endpoint de monitoreo `/health`

- ✅ **Containerización**: Dockerfile y docker-compose incluidos```- 🛡️ **Preservación de archivos originales**

- ✅ **Colección Postman**: Pruebas automatizadas con validaciones

EcoLogistics Integration System

## 🛠 Tecnologías

├── REST API (Apache Camel + Spring Boot)### 🏗️ Arquitectura

| Tecnología | Versión | Propósito |

|-----------|---------|-----------|│   ├── /api/envios - Gestión de envíos```

| Java | 21 | Lenguaje de programación |

| Spring Boot | 3.5.7 | Framework backend |│   ├── /api/vehiculos - Gestión de vehículosInput Folder → [Filter CSV] → [Transform] → Output Folder

| Apache Camel | 4.14.0 | Patrones de integración empresarial |

| Gradle | 8.x | Gestión de dependencias y build |│   └── /api-doc - Documentación OpenAPI                                      ↓

| Docker | 20.x+ | Containerización |

├── File Processing (Apache Camel Routes)                              Archived Folder (with timestamp)

## 📦 Requisitos Previos

│   ├── Procesamiento de CSV de envíos```

### Opción 1: Ejecución Local

- **Java JDK 21** o superior│   ├── Procesamiento de CSV de vehículos

- **Gradle 8.x** (incluido en wrapper)

- **Git** para clonar el repositorio│   └── Archivado automático## 📁 Estructura del Proyecto



### Opción 2: Ejecución con Docker└── Web Interface```

- **Docker Desktop** o **Docker Engine 20.x+**

- **Docker Compose** (incluido en Docker Desktop)    └── Dashboard básico para monitoreofirst-camel-project/



### Para Pruebas```├── src/main/java/

- **Postman** o **Newman** (opcional, para ejecutar la colección de pruebas)

│   └── com/integracion/camel/first_camel_project/

## 🚀 Instalación

## Tecnologías Utilizadas│       ├── FirstCamelProjectApplication.java

### 1. Clonar el repositorio

│       └── FileRoute.java                     # 🎯 Flujo principal Camel

```bash

git clone https://github.com/EstebanEr-03/first-camel-project.git- **Java 21** - Lenguaje de programación├── src/main/resources/

cd first-camel-project

git checkout ecologistics-sa- **Spring Boot 3.5.7** - Framework de aplicación│   └── application.properties                 # ⚙️ Configuraciones

```

- **Apache Camel 4.14.0** - Patrones de integración empresarial├── input/                                     # 📥 Archivos de entrada

### 2. Verificar archivo de datos

- **Gradle** - Gestión de dependencias y construcción├── output/                                    # 📤 Archivos procesados  

Asegúrate de que el archivo `envios.csv` existe en la raíz del proyecto con al menos 3 registros:

- **OpenAPI 3.0** - Documentación de API├── archived/                                  # 📚 Archivos archivados

```csv

id_envio,cliente,direccion,estado- **Jackson** - Serialización JSON├── logs/                                      # 📋 Logs del sistema

001,Juan Pérez,Calle 12 #45,Entregado

002,María Gómez,Avenida 10 #33,En tránsito└── build.gradle                               # 🔧 Configuración del proyecto

003,Luis Mora,Carrera 8 #22,Pendiente

```## Estructura del Proyecto```



## 🏃 Ejecución



### Opción 1: Ejecución Local con Gradle (Recomendado)```## 🚀 Cómo Ejecutar



#### Windows:/evaluacion-practica-ecologistics/

```powershell

# Compilar el proyecto├── src/### Prerequisitos

.\gradlew.bat clean build -x test

│   └── main/- Java 21 (LTS)

# Ejecutar la aplicación

.\gradlew.bat bootRun│       ├── java/- Gradle 8.x

```

│       │   └── com/ecologistics/integration/

#### Linux/Mac:

```bash│       │       ├── EcoLogisticsApplication.java### Pasos de Ejecución

# Compilar el proyecto

./gradlew clean build -x test│       │       ├── model/1. **Clonar el repositorio** (si aplica)



# Ejecutar la aplicación│       │       │   ├── Envio.java2. **Compilar el proyecto:**

./gradlew bootRun

```│       │       │   └── Vehiculo.java   ```bash



La aplicación estará disponible en: **http://localhost:8082**│       │       ├── routes/   ./gradlew build



### Opción 2: Ejecución con Docker Compose (Producción)│       │       │   ├── EcoLogisticsRestRoute.java   ```



```bash│       │       │   └── FileProcessingRoute.java3. **Ejecutar la aplicación:**

# Construir y ejecutar el contenedor

docker-compose up -d│       │       └── service/   ```bash



# Ver logs│       └── resources/   ./gradlew bootRun

docker-compose logs -f

│           ├── application.properties   ```

# Detener el contenedor

docker-compose down│           ├── openapi.yaml

```

│           └── static/### 📥 Datos de Prueba

### Opción 3: Ejecución con Docker (Manual)

│               └── index.htmlColoca archivos CSV en la carpeta `input/` para procesamiento automático.

```bash

# Construir la imagen├── input/               # Carpeta para archivos CSV de entrada

docker build -t ecologistics-api:1.0.0 .

├── output/              # Carpeta para archivos procesadosEjemplo (`ventas.csv`):

# Ejecutar el contenedor

docker run -d \├── archived/            # Carpeta para archivos archivados```csv

  --name ecologistics-api \

  -p 8082:8082 \├── envios.csv          # Archivo de ejemplo de envíosid,producto,cantidad,precio

  -v $(pwd)/envios.csv:/app/envios.csv:ro \

  ecologistics-api:1.0.0├── openapi.yaml        # Especificación OpenAPI1,Monitor,2,150



# Ver logs├── postman_collection.json  # Colección de Postman (pendiente)2,Teclado,5,25

docker logs -f ecologistics-api

├── README.md           # Este archivo3,Mouse,3,15

# Detener el contenedor

docker stop ecologistics-api└── reflexion.pdf       # Documento de evidencias (pendiente)```

docker rm ecologistics-api

``````



### Verificar que la aplicación está corriendo## 🔧 Configuración



```bash## Funcionalidades Implementadas

# Verificar health check

curl http://localhost:8082/api/health### Java Version



# Listar envíos### API RESTEl proyecto está configurado para usar **Java 21**:

curl http://localhost:8082/api/envios

``````gradle



## 📡 Endpoints de la API#### Gestión de Envíosjava {



### Base URL- `GET /api/envios` - Listar todos los envíos    toolchain { languageVersion = JavaLanguageVersion.of(21) }

```

http://localhost:8082/api- `POST /api/envios` - Crear nuevo envío}

```

- `GET /api/envios/{id}` - Obtener envío por ID```

### Endpoints Disponibles



#### 1. Health Check

```http#### Gestión de Vehículos### Dependencies

GET /api/health

```- `GET /api/vehiculos` - Listar todos los vehículos- Spring Boot Starter Web



**Respuesta exitosa (200):**- `POST /api/vehiculos` - Registrar nuevo vehículo- Spring Boot Actuator  

```json

{- `GET /api/vehiculos/disponibles` - Obtener vehículos disponibles- Camel Spring Boot Starter

  "status": "UP",

  "application": "EcoLogistics Integration System",- Camel File Component

  "version": "1.0.0",

  "timestamp": "2025-10-29T20:30:45.123",### Procesamiento de Archivos- Camel Log Component

  "enviosCount": 4

}- Monitoreo automático de la carpeta `input/`

```

- Procesamiento de archivos CSV de envíos y vehículos## 📊 Flujos de Integración

#### 2. Listar Todos los Envíos

```http- Archivado automático de archivos procesados

GET /api/envios

```- Generación de archivos de salida con timestamp### 1. File Transfer Route



**Respuesta exitosa (200):**- **Origen:** `file:input?noop=true&delay=5000`

```json

[## Instalación y Ejecución- **Filtro:** Solo archivos `.csv`

  {

    "id": "001",- **Transformación:** Convertir a mayúsculas

    "cliente": "Juan Pérez",

    "direccion": "Calle 12 #45",### Prerrequisitos- **Destinos:** 

    "estado": "Entregado"

  },- Java 21 o superior  - `output/` (archivos procesados)

  {

    "id": "002",- Gradle 7.0 o superior  - `archived/` (con timestamp)

    "cliente": "María Gómez",

    "direccion": "Avenida 10 #33",

    "estado": "En tránsito"

  }### Pasos para ejecutar### 2. Log Monitor Route  

]

```- **Origen:** `file:logs?noop=true&delay=10000`



#### 3. Obtener Envío por ID1. **Clonar o descargar el proyecto**- **Filtro:** Solo archivos `.log`

```http

GET /api/envios/{id}   ```bash- **Acción:** Logging de monitoreo

```

   git clone <repository-url>

**Ejemplo:**

```bash   cd evaluacion-practica-ecologistics## 📝 Logs de Ejemplo

curl http://localhost:8082/api/envios/001

```   ``````



**Respuesta exitosa (200):**2025-10-25 09:30:49 - Procesando archivo: ventas.csv - Fecha: 2025-10-25 09:30:49

```json

{2. **Compilar el proyecto**2025-10-25 09:30:49 - Archivo CSV válido: ventas.csv  

  "id": "001",

  "cliente": "Juan Pérez",   ```bash2025-10-25 09:30:49 - Contenido transformado a mayúsculas

  "direccion": "Calle 12 #45",

  "estado": "Entregado"   ./gradlew build2025-10-25 09:30:49 - Archivo copiado a output: ventas.csv

}

```   ```2025-10-25 09:30:50 - Archivo archivado con timestamp: ventas-20251025-093050.csv



**Envío no encontrado (404):**```

```json

{3. **Ejecutar la aplicación**

  "error": "Envío no encontrado"

}   ```bash## 🎯 Casos de Uso

```

   ./gradlew bootRun- Integración de sistemas legacy

#### 4. Crear Nuevo Envío

```http   ```- Procesamiento batch de datos

POST /api/envios

Content-Type: application/json- Intercambio B2B de archivos

```

4. **Verificar que está funcionando**- Transformación automática de formatos

**Body:**

```json   - API REST: http://localhost:8081/api- Sistemas de auditoría y archivado

{

  "cliente": "Carlos Ramírez",   - Documentación OpenAPI: http://localhost:8081/api-doc

  "direccion": "Avenida 50 #100",

  "estado": "En preparación"   - Dashboard: http://localhost:8081## 📚 Documentación Adicional

}

```- `ENTREGABLES_TALLER_CAMEL.md` - Documento completo de entregables



**Respuesta exitosa (201):**## Uso del Sistema- `INFORME_LABORATORIO.md` - Informe técnico detallado

```json

{

  "id": "004",

  "cliente": "Carlos Ramírez",### 1. Procesamiento de Archivos CSV## 👨‍💻 Desarrollo

  "direccion": "Avenida 50 #100",

  "estado": "En preparación"Este proyecto fue desarrollado como parte del taller de **Integración de Sistemas** utilizando **Enterprise Integration Patterns** con **Apache Camel**.

}

```Coloca archivos CSV en la carpeta `input/` con los siguientes formatos:



#### 5. Documentación OpenAPI---

```http

GET /api/api-doc**Archivos de envíos** (nombre debe contener "envios"):*Proyecto educativo - Integración de Sistemas con Apache Camel y Java 21*

``````csv

id,origen,destino,descripcion,peso,estado,fechaCreacion,vehiculoAsignado

Retorna la especificación completa de la API en formato OpenAPI 3.0.ENV001,Bogotá,Medellín,Paquete de documentos,2.5,EN_TRANSITO,2025-10-29 10:30:00,VEH001

```

## 🧪 Pruebas

**Archivos de vehículos** (nombre debe contener "vehiculos"):

### Opción 1: Pruebas con Postman```csv

id,placa,tipo,capacidad,estado,conductor,ubicacionActual

1. **Importar la colección**:VEH001,ABC123,CAMION,1500.0,DISPONIBLE,Juan Pérez,Bogotá

   - Abrir Postman```

   - Ir a `File` → `Import`

   - Seleccionar el archivo `postman_collection.json`### 2. API REST



2. **Ejecutar todas las pruebas**:#### Crear un nuevo envío

   - Clic derecho en la colección "EcoLogistics API"```bash

   - Seleccionar `Run collection`curl -X POST http://localhost:8081/api/envios \

   - Clic en `Run EcoLogistics API`  -H "Content-Type: application/json" \

  -d '{

3. **Variables de entorno** (opcional):    "origen": "Bogotá",

   - Crear un entorno llamado "EcoLogistics"    "destino": "Medellín",

   - Agregar variable: `base_url` = `http://localhost:8082`    "descripcion": "Paquete urgente",

    "peso": 5.0

### Opción 2: Pruebas con Newman (CLI)  }'

```

```bash

# Instalar Newman globalmente#### Listar todos los envíos

npm install -g newman```bash

curl http://localhost:8081/api/envios

# Ejecutar la colección```

newman run postman_collection.json

#### Obtener vehículos disponibles

# Ejecutar con reporte HTML```bash

newman run postman_collection.json -r html --reporter-html-export newman-report.htmlcurl http://localhost:8081/api/vehiculos/disponibles

``````



### Opción 3: Pruebas Manuales con cURL## Patrones de Integración Implementados



```bash1. **File Adapter Pattern** - Procesamiento automático de archivos CSV

# 1. Health Check2. **Message Router** - Enrutamiento basado en tipo de archivo

curl http://localhost:8082/api/health3. **Content Enricher** - Enriquecimiento de datos con timestamps y IDs

4. **Message Translator** - Conversión de CSV a JSON

# 2. Listar todos los envíos5. **Dead Letter Channel** - Manejo de archivos no procesables

curl http://localhost:8082/api/envios

## Monitoreo y Logs

# 3. Obtener envío específico

curl http://localhost:8082/api/envios/001- Los logs de la aplicación se muestran en consola con nivel DEBUG para el paquete de EcoLogistics

- El procesamiento de archivos se registra detalladamente

# 4. Crear nuevo envío- Los endpoints REST registran todas las operaciones

curl -X POST http://localhost:8082/api/envios \

  -H "Content-Type: application/json" \## Próximas Funcionalidades

  -d '{"cliente":"Test User","direccion":"Calle Test 123","estado":"Pendiente"}'

- [ ] Integración con base de datos

# 5. Obtener documentación OpenAPI- [ ] Autenticación y autorización

curl http://localhost:8082/api/api-doc- [ ] Notificaciones por email

```- [ ] Dashboard avanzado con métricas

- [ ] API de seguimiento en tiempo real

### Opción 4: Pruebas con PowerShell- [ ] Integración con sistemas de terceros



```powershell## Documentación Adicional

# Health Check

Invoke-RestMethod -Uri http://localhost:8082/api/health -Method GET- **OpenAPI Specification**: `openapi.yaml`

- **Colección de Postman**: `postman_collection.json` (pendiente)

# Listar envíos- **Documento de Reflexión**: `reflexion.pdf` (pendiente)

Invoke-RestMethod -Uri http://localhost:8082/api/envios -Method GET | ConvertTo-Json

## Soporte

# Crear nuevo envío

$body = @{ Para soporte técnico contactar a la Gerencia de TI de EcoLogistics S.A.:

    cliente = "Test User"- Email: ti@ecologistics.com

    direccion = "Calle Test 123"- Documentación: http://localhost:8081/api-doc

    estado = "Pendiente"

} | ConvertTo-Json---



Invoke-RestMethod -Uri http://localhost:8082/api/envios -Method POST -Body $body -ContentType "application/json"**EcoLogistics S.A.** - Modernizando el transporte y la distribución
```

### Resultados Esperados

La colección de Postman incluye **validaciones automáticas** que verifican:

- ✅ Códigos de estado HTTP correctos (200, 201, 404)
- ✅ Estructura JSON de las respuestas
- ✅ Presencia de campos obligatorios
- ✅ Valores correctos en los datos
- ✅ Funcionalidad de creación de envíos
- ✅ Manejo correcto de errores

## 🐳 Docker

### Construcción de la Imagen

```bash
docker build -t ecologistics-api:1.0.0 .
```

### Ejecución con Docker Compose

```bash
# Iniciar servicios
docker-compose up -d

# Ver logs en tiempo real
docker-compose logs -f

# Verificar estado
docker-compose ps

# Detener servicios
docker-compose down

# Detener y eliminar volúmenes
docker-compose down -v
```

### Configuración del Health Check

El contenedor incluye un health check que verifica el estado cada 30 segundos:

```bash
# Ver estado del health check
docker inspect ecologistics-integration | grep -A 10 Health
```

### Variables de Entorno

Puedes personalizar la configuración mediante variables de entorno:

```bash
docker run -d \
  -p 8082:8082 \
  -e JAVA_OPTS="-Xmx1g -Xms512m" \
  -e SERVER_PORT=8082 \
  ecologistics-api:1.0.0
```

## 📁 Estructura del Proyecto

```
first-camel-project/
├── src/
│   ├── main/
│   │   ├── java/com/ecologistics/integration/
│   │   │   ├── EcoLogisticsApplication.java       # Aplicación principal
│   │   │   ├── config/
│   │   │   │   └── ServletConfig.java             # Configuración servlet
│   │   │   ├── model/
│   │   │   │   ├── EnvioSpec.java                 # Modelo de envío
│   │   │   │   ├── Envio.java                     # Modelo alternativo
│   │   │   │   └── Vehiculo.java                  # Modelo de vehículo
│   │   │   ├── routes/
│   │   │   │   ├── EcoLogisticsSpecRoute.java     # Rutas REST principales
│   │   │   │   ├── EcoLogisticsRestRoute.java     # Rutas alternativas
│   │   │   │   └── FileProcessingRoute.java       # Rutas de archivos
│   │   │   └── service/
│   │   │       └── EnvioService.java              # Lógica de negocio
│   │   └── resources/
│   │       ├── application.properties              # Configuración Spring
│   │       ├── openapi.yaml                        # Especificación OpenAPI
│   │       └── static/
│   │           └── index.html                      # Página de bienvenida
│   └── test/
│       └── java/com/ecologistics/integration/
│           └── EcoLogisticsApplicationTests.java   # Tests
├── envios.csv                                       # Datos de entrada
├── build.gradle                                     # Configuración Gradle
├── settings.gradle                                  # Settings Gradle
├── Dockerfile                                       # Dockerfile multi-stage
├── docker-compose.yml                               # Orquestación Docker
├── .dockerignore                                    # Exclusiones Docker
├── postman_collection.json                          # Colección Postman
└── README.md                                        # Este archivo
```

## 📊 Logs y Trazabilidad

La aplicación genera logs detallados en consola:

```
[INFO] Iniciando carga de archivo CSV...
[INFO] Leyendo archivo envios.csv...
[INFO] Archivo cargado con 3 registros.
[INFO] Datos transformados a formato JSON.
[INFO] API iniciada en puerto 8082.
[INFO] Solicitud GET /envios recibida
[INFO] Respondiendo con 4 envíos
```

## 🔧 Configuración

### application.properties

```properties
# Puerto del servidor
server.port=8082

# Nombre de la aplicación
spring.application.name=ecologistics-integration

# Configuración de Camel
camel.main.run-controller=true
camel.component.servlet.mapping.enabled=false
```

## 🎯 Patrones de Integración Implementados

1. **File Transfer Pattern**: Lectura de archivo CSV local
2. **Message Transformation**: Conversión CSV → JSON
3. **Content-Based Router**: Enrutamiento según tipo de petición
4. **RESTful API**: Exposición de servicios HTTP

## 📝 Estructura JSON Estandarizada

Todos los endpoints retornan envíos en el siguiente formato:

```json
{
  "id": "001",
  "cliente": "Juan Pérez",
  "direccion": "Calle 12 #45",
  "estado": "Entregado"
}
```

## 🤝 Contribución

Este es un proyecto académico desarrollado para EcoLogistics S.A. como parte de la modernización de su ecosistema tecnológico.

## 📄 Licencia

Este proyecto es propiedad de EcoLogistics S.A. - Todos los derechos reservados.

## 👥 Autores

- **Gerencia de TI** - EcoLogistics S.A.
- **Equipo de Arquitectura** - Desarrollo del prototipo

## 📞 Soporte

Para soporte técnico, contactar a: ti@ecologistics.com

---

**EcoLogistics S.A.** - Modernizando el transporte y la logística 🚚✨
