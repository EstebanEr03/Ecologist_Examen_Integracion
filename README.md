# EcoLogistics Integration System# 🐪 Apache Camel - File Transfer Integration Project



Sistema de integración para modernizar el ecosistema tecnológico de EcoLogistics S.A., empresa de transporte y distribución.## Descripción

Proyecto de integración de sistemas utilizando **Apache Camel** con **Spring Boot** que implementa el patrón **File Transfer** para procesar archivos CSV con transformaciones automáticas.

## Descripción del Proyecto

## 🚀 Tecnologías Utilizadas

EcoLogistics S.A. busca reemplazar su sistema tradicional de envío de archivos CSV por correo electrónico con una solución moderna basada en APIs RESTful, aplicando patrones clásicos de integración con Apache Camel.- **Java 21** (LTS)

- **Spring Boot 3.5.7**

### Problemática Actual- **Apache Camel 4.14.0**

- Manejo manual y descentralizado de información de envíos y vehículos- **Gradle 8.14.3**

- Supervisores envían archivos CSV por correo electrónico diariamente- **Enterprise Integration Patterns (EIP)**

- Falta de integración y automatización en los procesos

## 📋 Características Principales

### Solución Propuesta

- API REST moderna para gestión de envíos y vehículos### ✨ Funcionalidades Implementadas

- Procesamiento automático de archivos CSV- 📁 **Procesamiento automático** de archivos CSV

- Integración con Apache Camel y patrones de integración empresarial- 🔄 **Transformación de contenido** a mayúsculas

- Documentación OpenAPI completa- 📊 **Filtrado por tipo de archivo** (.csv)

- 💾 **Archivado con timestamp** para auditoría

## Arquitectura del Sistema- 📝 **Logging detallado** con fecha y hora

- 👁️ **Monitoreo de archivos** de log

```- 🛡️ **Preservación de archivos originales**

EcoLogistics Integration System

├── REST API (Apache Camel + Spring Boot)### 🏗️ Arquitectura

│   ├── /api/envios - Gestión de envíos```

│   ├── /api/vehiculos - Gestión de vehículosInput Folder → [Filter CSV] → [Transform] → Output Folder

│   └── /api-doc - Documentación OpenAPI                                      ↓

├── File Processing (Apache Camel Routes)                              Archived Folder (with timestamp)

│   ├── Procesamiento de CSV de envíos```

│   ├── Procesamiento de CSV de vehículos

│   └── Archivado automático## 📁 Estructura del Proyecto

└── Web Interface```

    └── Dashboard básico para monitoreofirst-camel-project/

```├── src/main/java/

│   └── com/integracion/camel/first_camel_project/

## Tecnologías Utilizadas│       ├── FirstCamelProjectApplication.java

│       └── FileRoute.java                     # 🎯 Flujo principal Camel

- **Java 21** - Lenguaje de programación├── src/main/resources/

- **Spring Boot 3.5.7** - Framework de aplicación│   └── application.properties                 # ⚙️ Configuraciones

- **Apache Camel 4.14.0** - Patrones de integración empresarial├── input/                                     # 📥 Archivos de entrada

- **Gradle** - Gestión de dependencias y construcción├── output/                                    # 📤 Archivos procesados  

- **OpenAPI 3.0** - Documentación de API├── archived/                                  # 📚 Archivos archivados

- **Jackson** - Serialización JSON├── logs/                                      # 📋 Logs del sistema

└── build.gradle                               # 🔧 Configuración del proyecto

## Estructura del Proyecto```



```## 🚀 Cómo Ejecutar

/evaluacion-practica-ecologistics/

├── src/### Prerequisitos

│   └── main/- Java 21 (LTS)

│       ├── java/- Gradle 8.x

│       │   └── com/ecologistics/integration/

│       │       ├── EcoLogisticsApplication.java### Pasos de Ejecución

│       │       ├── model/1. **Clonar el repositorio** (si aplica)

│       │       │   ├── Envio.java2. **Compilar el proyecto:**

│       │       │   └── Vehiculo.java   ```bash

│       │       ├── routes/   ./gradlew build

│       │       │   ├── EcoLogisticsRestRoute.java   ```

│       │       │   └── FileProcessingRoute.java3. **Ejecutar la aplicación:**

│       │       └── service/   ```bash

│       └── resources/   ./gradlew bootRun

│           ├── application.properties   ```

│           ├── openapi.yaml

│           └── static/### 📥 Datos de Prueba

│               └── index.htmlColoca archivos CSV en la carpeta `input/` para procesamiento automático.

├── input/               # Carpeta para archivos CSV de entrada

├── output/              # Carpeta para archivos procesadosEjemplo (`ventas.csv`):

├── archived/            # Carpeta para archivos archivados```csv

├── envios.csv          # Archivo de ejemplo de envíosid,producto,cantidad,precio

├── openapi.yaml        # Especificación OpenAPI1,Monitor,2,150

├── postman_collection.json  # Colección de Postman (pendiente)2,Teclado,5,25

├── README.md           # Este archivo3,Mouse,3,15

└── reflexion.pdf       # Documento de evidencias (pendiente)```

```

## 🔧 Configuración

## Funcionalidades Implementadas

### Java Version

### API RESTEl proyecto está configurado para usar **Java 21**:

```gradle

#### Gestión de Envíosjava {

- `GET /api/envios` - Listar todos los envíos    toolchain { languageVersion = JavaLanguageVersion.of(21) }

- `POST /api/envios` - Crear nuevo envío}

- `GET /api/envios/{id}` - Obtener envío por ID```



#### Gestión de Vehículos### Dependencies

- `GET /api/vehiculos` - Listar todos los vehículos- Spring Boot Starter Web

- `POST /api/vehiculos` - Registrar nuevo vehículo- Spring Boot Actuator  

- `GET /api/vehiculos/disponibles` - Obtener vehículos disponibles- Camel Spring Boot Starter

- Camel File Component

### Procesamiento de Archivos- Camel Log Component

- Monitoreo automático de la carpeta `input/`

- Procesamiento de archivos CSV de envíos y vehículos## 📊 Flujos de Integración

- Archivado automático de archivos procesados

- Generación de archivos de salida con timestamp### 1. File Transfer Route

- **Origen:** `file:input?noop=true&delay=5000`

## Instalación y Ejecución- **Filtro:** Solo archivos `.csv`

- **Transformación:** Convertir a mayúsculas

### Prerrequisitos- **Destinos:** 

- Java 21 o superior  - `output/` (archivos procesados)

- Gradle 7.0 o superior  - `archived/` (con timestamp)



### Pasos para ejecutar### 2. Log Monitor Route  

- **Origen:** `file:logs?noop=true&delay=10000`

1. **Clonar o descargar el proyecto**- **Filtro:** Solo archivos `.log`

   ```bash- **Acción:** Logging de monitoreo

   git clone <repository-url>

   cd evaluacion-practica-ecologistics## 📝 Logs de Ejemplo

   ``````

2025-10-25 09:30:49 - Procesando archivo: ventas.csv - Fecha: 2025-10-25 09:30:49

2. **Compilar el proyecto**2025-10-25 09:30:49 - Archivo CSV válido: ventas.csv  

   ```bash2025-10-25 09:30:49 - Contenido transformado a mayúsculas

   ./gradlew build2025-10-25 09:30:49 - Archivo copiado a output: ventas.csv

   ```2025-10-25 09:30:50 - Archivo archivado con timestamp: ventas-20251025-093050.csv

```

3. **Ejecutar la aplicación**

   ```bash## 🎯 Casos de Uso

   ./gradlew bootRun- Integración de sistemas legacy

   ```- Procesamiento batch de datos

- Intercambio B2B de archivos

4. **Verificar que está funcionando**- Transformación automática de formatos

   - API REST: http://localhost:8081/api- Sistemas de auditoría y archivado

   - Documentación OpenAPI: http://localhost:8081/api-doc

   - Dashboard: http://localhost:8081## 📚 Documentación Adicional

- `ENTREGABLES_TALLER_CAMEL.md` - Documento completo de entregables

## Uso del Sistema- `INFORME_LABORATORIO.md` - Informe técnico detallado



### 1. Procesamiento de Archivos CSV## 👨‍💻 Desarrollo

Este proyecto fue desarrollado como parte del taller de **Integración de Sistemas** utilizando **Enterprise Integration Patterns** con **Apache Camel**.

Coloca archivos CSV en la carpeta `input/` con los siguientes formatos:

---

**Archivos de envíos** (nombre debe contener "envios"):*Proyecto educativo - Integración de Sistemas con Apache Camel y Java 21*
```csv
id,origen,destino,descripcion,peso,estado,fechaCreacion,vehiculoAsignado
ENV001,Bogotá,Medellín,Paquete de documentos,2.5,EN_TRANSITO,2025-10-29 10:30:00,VEH001
```

**Archivos de vehículos** (nombre debe contener "vehiculos"):
```csv
id,placa,tipo,capacidad,estado,conductor,ubicacionActual
VEH001,ABC123,CAMION,1500.0,DISPONIBLE,Juan Pérez,Bogotá
```

### 2. API REST

#### Crear un nuevo envío
```bash
curl -X POST http://localhost:8081/api/envios \
  -H "Content-Type: application/json" \
  -d '{
    "origen": "Bogotá",
    "destino": "Medellín",
    "descripcion": "Paquete urgente",
    "peso": 5.0
  }'
```

#### Listar todos los envíos
```bash
curl http://localhost:8081/api/envios
```

#### Obtener vehículos disponibles
```bash
curl http://localhost:8081/api/vehiculos/disponibles
```

## Patrones de Integración Implementados

1. **File Adapter Pattern** - Procesamiento automático de archivos CSV
2. **Message Router** - Enrutamiento basado en tipo de archivo
3. **Content Enricher** - Enriquecimiento de datos con timestamps y IDs
4. **Message Translator** - Conversión de CSV a JSON
5. **Dead Letter Channel** - Manejo de archivos no procesables

## Monitoreo y Logs

- Los logs de la aplicación se muestran en consola con nivel DEBUG para el paquete de EcoLogistics
- El procesamiento de archivos se registra detalladamente
- Los endpoints REST registran todas las operaciones

## Próximas Funcionalidades

- [ ] Integración con base de datos
- [ ] Autenticación y autorización
- [ ] Notificaciones por email
- [ ] Dashboard avanzado con métricas
- [ ] API de seguimiento en tiempo real
- [ ] Integración con sistemas de terceros

## Documentación Adicional

- **OpenAPI Specification**: `openapi.yaml`
- **Colección de Postman**: `postman_collection.json` (pendiente)
- **Documento de Reflexión**: `reflexion.pdf` (pendiente)

## Soporte

Para soporte técnico contactar a la Gerencia de TI de EcoLogistics S.A.:
- Email: ti@ecologistics.com
- Documentación: http://localhost:8081/api-doc

---

**EcoLogistics S.A.** - Modernizando el transporte y la distribución