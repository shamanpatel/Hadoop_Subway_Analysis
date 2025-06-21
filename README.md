# 🚇 Hadoop Subway Analysis

A Hadoop MapReduce project that processes NYC MTA turnstile data to compute total **entries** and **exits** on **December 30, 2022** across all control areas.

<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/4/4f/MTA_NYCT_logo.svg" alt="MTA Logo" width="120"/>
</p>

---

## 📌 Objective

To explore big data processing using Hadoop by analyzing a large dataset of subway turnstile logs and calculating:

- Total number of **entries**
- Total number of **exits**

…on a specific day: `12/30/2022`.

---

## 🛠️ Technologies Used

- Java
- Hadoop HDFS
- Hadoop MapReduce (YARN)
- Linux (Ubuntu)
- Git

---

## 📁 Project Structure

```bash
.
├── SubwayMapper.java     # Mapper class
├── SubwayReducer.java    # Reducer class
├── SubwayDriver.java     # Driver to configure and run job
├── mta_data.csv          # Input dataset (not included in repo)
├── build/                # Compiled .class files
├── Subway.jar            # Packaged jar file for Hadoop
└── README.md             # This file
