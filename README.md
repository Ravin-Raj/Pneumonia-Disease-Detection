# 🧠 Pneumonia Disease Detection using MobileNetV2 Model (Deep Learning)

This project presents an **AI-powered pneumonia detection system** using **MobileNetV2**, a lightweight convolutional neural network, to classify **Normal**, **Bacterial Pneumonia**, and **Viral Pneumonia** from chest X-ray images. The model integrates **image preprocessing (CLAHE and Median Filtering)** to improve feature extraction and diagnostic accuracy. The final trained model is converted to **TensorFlow Lite** for real-time deployment on Android mobile devices.

---

## 🩺 Abstract

Pneumonia is a respiratory disease that causes inflammation in the lungs. Early detection is crucial for effective treatment. This system automates pneumonia detection using **deep learning** to reduce manual diagnosis time. MobileNetV2 provides **high accuracy**, **low computation cost**, and **mobile deployment capability**, making it ideal for real-time medical diagnostics.

---

## 🚀 Objectives
- Automate pneumonia detection using deep learning.  
- Compare model accuracy with and without preprocessing.  
- Deploy the trained model to a mobile application using TensorFlow Lite.  
- Reduce diagnosis time and improve accessibility.

---

## 🛠️ Technologies Used

| Category | Technology |
|-----------|-------------|
| **Language** | Python |
| **Framework** | TensorFlow, Keras |
| **Environment** | Google Colab |
| **Deployment** | TensorFlow Lite, Android Studio |
| **Libraries** | NumPy, Pandas, Scikit-learn, OpenCV, Matplotlib |
| **Visualization** | Seaborn, Matplotlib |
| **Storage** | Google Drive |
| **OS** | Windows 11 |

---

## 🧩 System Modules

### 1. Dataset Preparation
- Dataset includes **7927 chest X-ray images** categorized into *Normal*, *Bacterial Pneumonia*, and *Viral Pneumonia*.
- Preprocessing includes **CLAHE (Contrast Limited Adaptive Histogram Equalization)** for contrast enhancement and **Median Filtering** for noise removal.
- Dataset split: **70% Train**, **20% Validation**, **10% Test**.
- Evaluated preprocessing using **PSNR (Peak Signal-to-Noise Ratio)** with an average of **48.86 dB**.

### 2. Model Development
- Used **MobileNetV2** with transfer learning from ImageNet weights.  
- Input image size: **128x128** pixels.  
- Optimizer: Adam | Loss: Categorical Crossentropy | Epochs: 25 | Batch size: 32.

### 3. Model Accuracy Comparison
| Configuration | Train Acc | Validation Acc | Test Acc |
|----------------|------------|----------------|-----------|
| Without Preprocessing | 94% | 84% | 83% |
| With Preprocessing | **99%** | **86%** | **84%** |

### 4. Performance Metrics
| Metric | Without Preprocessing | With Preprocessing |
|---------|------------------------|--------------------|
| Precision | 83% | 84% |
| Recall | 83% | 84% |
| F1-Score | 83% | 84% |

---

## 📱 Mobile Application Integration
- Model converted to **.tflite** format for deployment.  
- Integrated into Android Studio with **TensorFlow Lite Interpreter**.  
- Allows users to upload X-ray images and view predictions instantly.

**App Features:**
- Predicts: *Normal*, *Bacterial Pneumonia*, *Viral Pneumonia*.  
- Lightweight, real-time, and mobile-optimized model.

---

### 🧠 Model Workflow

1. **Data Collection**
   - Gathered chest X-ray images labeled as *Normal*, *Bacterial Pneumonia*, and *Viral Pneumonia*.

2. **Image Preprocessing**
   - Applied **CLAHE** for contrast enhancement.  
   - Used **Median Filtering** to remove noise.  
   - Resized images to 128×128 pixels.

3. **Data Augmentation**
   - Performed rotation, flipping, zoom, and normalization to improve model generalization.

4. **Model Training (MobileNetV2)**
   - Transfer learning with pretrained ImageNet weights.  
   - Optimizer: Adam | Epochs: 25 | Batch size: 32.  
   - Output classes: Normal, Bacterial, Viral.

5. **Model Evaluation**
   - Metrics: Accuracy, Precision, Recall, F1-Score, Confusion Matrix.

6. **Model Conversion**
   - Converted the trained model (`.h5`) to **TensorFlow Lite (.tflite)** for mobile deployment.

7. **Mobile App Integration**
   - Integrated with **Android Studio** using TensorFlow Lite Interpreter.  
   - User uploads X-ray → Model predicts disease type in real-time.

8. **Output**
   - ✅ *Normal*  
   - 🦠 *Bacterial Pneumonia*  
   - 🧬 *Viral Pneumonia*

---

## 🧪 Results
- **Average PSNR:** 48.86 dB – excellent image clarity after preprocessing.  
- **Accuracy Improvement:** +5% with preprocessing.  
- **Model Size:** Optimized for mobile deployment.  
- **Prediction Speed:** ~2 seconds per image.  

---

## 🌟 Advantages
- Lightweight, mobile-optimized deep learning model.  
- High accuracy and real-time processing.  
- Automated, non-invasive pneumonia detection.  
- Works offline with no data upload required.  
- Cost-effective diagnostic tool for remote areas.

---

## 🔮 Future Enhancements
- Integrate with cloud (Firebase / AWS) for online diagnosis.  
- Include additional diseases like COVID-19 and Tuberculosis.  
- Implement Explainable AI using **Grad-CAM visualization**.  
- Add multilingual and voice support.  
- Expand into full telemedicine ecosystem.

---

## 🧾 Conclusion
This project successfully demonstrates how **MobileNetV2** can be leveraged for medical image classification with excellent performance and efficiency. The system provides a scalable, mobile-friendly solution for early pneumonia detection, improving access to diagnostic tools in underdeveloped and rural healthcare systems.

---

## 👨‍💻 Developer
**Ravin Raj S (23322009)**  
Department of Computer Science and Applications  
The Gandhigram Rural Institute (Deemed to be University)  
📅 *April 2025*

---

## 📚 References
- Sandler, M. et al. (2018). *MobileNetV2: Inverted Residuals and Linear Bottlenecks*. [arXiv:1801.04381](https://arxiv.org/abs/1801.04381)  
- Mooney, P. (2018). *Chest X-Ray Images (Pneumonia)* – Kaggle Dataset  
- TensorFlow Lite: [tensorflow.org/lite](https://www.tensorflow.org/lite/models/image_classification/overview)  
- OpenCV CLAHE Docs: [docs.opencv.org](https://docs.opencv.org/4.x/d5/daf/tutorial_py_histogram_equalization.html)  
- Scikit-Image Median Filter: [scikit-image.org](https://scikit-image.org/docs/stable/auto_examples/filters/plot_rank_filters.html)

---

## 🪪 License
This project is open-source and licensed under the **MIT License**.
