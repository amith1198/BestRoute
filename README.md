# BestRoute Delivery Optimizer

## 🚀 Problem Statement
A delivery executive, **Aman** , is assigned a batch of multiple orders from different **restaurants** to be delivered to different **consumers** in the shortest possible time.

The goal is to **optimize the sequence** in which orders are picked up and delivered **to minimize overall delivery time**.

---

## 🏗️ Approach

### Define Key Models
- `GeoLocation`: Represents a location with latitude and longitude.
- `Restaurant`: Has a unique ID, a `GeoLocation`, and a **preparation time**.
- `Consumer`: Has a unique ID and a `GeoLocation`.
- `Order`: Contains **a restaurant and a consumer**.
- `DistanceCalculator` (Interface): Defines methods for distance and travel time calculations.
- `HaversineDistanceCalculator`: Implements the `DistanceCalculator` interface using the **Haversine formula**.
- `DeliveryOptimizer`: Implements an optimized strategy for **picking up and delivering orders** efficiently.

---

### Expected Output
```sh
Optimized Delivery Time: X minutes
```

---

## 📂 Project Structure
```
com.bestroute
│── model
│   ├── Consumer.java
│   ├── GeoLocation.java
│   ├── Order.java
│   ├── Restaurant.java
│
│── service
│   ├── DeliveryOptimizer.java
│
│── util
│   ├── DistanceCalculator.java
│   ├── HaversineDistanceCalculator.java
│
│── Main.java
```

---

## 🧪 Unit Tests
- **100% Code Coverage**
- Written using **JUnit**
- Run tests with:
```sh
$ ./gradlew test
```

---

## 📌 Notes
- Uses **Haversine formula** for calculating real-world distances.
- Supports **dynamic order batches** with `n` restaurants and `n` consumers.
- Fully optimized for efficient deliveries.

---


