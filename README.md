# PlateLoc
Abstract: Using image processing methods and the OpenCV library, this project tries to create a system for automatically recognising license plates. License plate localization and license plate image processing will be the system's two key focuses. In order to analyze an image further and extract the license plate number, license plate localization aims to precisely and quickly locate the license plate in the frame. Instead of employing machine learning algorithms, this will be accomplished using conventional image processing approaches. Image acquisition, image enhancement, and final image processing are the three stages of the license plate image processing process. The finished system will be highly accurate and effective in reading license 

# INTRODUCTION
For several applications, including automated toll collection, parking lot management, and traffic monitoring, license plate localisation is essential. This technique aims to quickly and precisely locate the license plate in an image so that the license plate number can be recovered and the image processed further. Usually, machine learning methods and image processing techniques are used for this. Image acquisition, image enhancement, and final image processing are the three stages of license plate image processing. Using cameras and analog-to-digital converters, images are captured and digitally converted throughout the image acquisition process. Image enhancement improves the image by removing some interference elements and lowering noise to produce a more accurate image that is better suited for presentation or further research. Binarization, grayscale conversion, Gaussian smoothing, and edge detection are the last image processing stages that get the LP image ready for further processing and analysis. The project's overarching goal is to create a useful application that can locate the license plate on the dataset using several horizontal lines, recognise the plate number, and perform the best picture improvement for the dataset.

# METHODS

![image](https://github.com/afifimran/PlateLoc/assets/96810907/36fb9e5f-4f73-464f-a12a-18f46ff1eeee)


Image acquisition

	The dataset that uses contains 97 images of vehicles with plate numbers that need to be located and extracted. The data set is in RGB color model type and needs to do some image enhancement in order to delete the unwanted noise on the image. There are noise and lighting problems in the dataset and this will affect the accuracy of the plate number localization. 
	
Image pre-processing

	The method of image pre-processing used in this model includes converting the RGB color space to grayscale, applying a bilateral filter to reduce noise and preserve edge information, enhancing image contrast through histogram equalization, extracting structural information with morphological operations, subtracting the result from a reference image, thresholding to produce a binary image, and using Canny edge detection to identify objects. To fill in any blanks or holes in the image of the license plate, dilation and morphological image processing are required for plate number localisation. Dilation helps to connect any broken areas of the license plate by enlarging the pixels in an image. This can help to join any broken white pixels that make up the license plate, which is especially helpful if the image has been thresholded. To fill in any blanks or holes in the image of the license plate, dilation and morphological image processing are required for plate number localisation. Dilation helps to connect any broken areas of the license plate by enlarging the pixels in an image. This can help to join any broken white pixels that make up the license plate, which is especially helpful if the image has been threshold. This method is recomment In summary, the plate number localization procedure greatly benefits from image pre-processing. It is possible to efficiently remove noise and improve the image quality by converting the image to grayscale, filtering it with a bilateral filter, boosting its contrast with histogram equalization, applying morphological operations and subtracting the image, and using thresholding to create a binary image. The precise extraction and localization of the licence plate number on the vehicle is made possible by the employment of Canny edge detection and contour detection. In general, image pre-processing methods are crucial for enabling precise vehicle recognition and assuring the success of plate number localisation.
	
	![image](https://github.com/afifimran/PlateLoc/assets/96810907/579e9625-b1a4-46dc-aba6-6f0d8ecaa142)


	![image](https://github.com/afifimran/PlateLoc/assets/96810907/0a0ebbcf-569d-478e-806a-02f4b0351ef0)
	
	
	![image](https://github.com/afifimran/PlateLoc/assets/96810907/8e3f689e-8a19-4cf0-9b19-ebcc1fe9b877)
	

	
Contour detection

	Because Canny edge detection simply finds edges in an image and does not group them together, contour detection is performed after Canny edge detection. The boundaries of an object with comparable intensity levels in a picture are referred to as contours. It is simpler to discover and extract specific items in the image, such as the license plate numbers of a car, by employing contour detection following canny edge detection, which groups the detected edges to establish the boundaries of an object. The shape, size, and placement of an object in an image can be determined via contour detection, which can then be applied to additional image processing tasks including segmentation, recognition, and tracking.
	
Plate number region

	The definition of a plate number in the context of plate number localization is the run of letters or digits that appear on a vehicle's license plate. This data, which is often seen on the front or rear of the vehicle, is used to identify the vehicle. Because the contours have been identified on the image, the contour that belongs to the plate can be compared to the approximation and the location of the plate number is shown in the green rectangle on the image. The contour that does not belong to the plate number will be ignored and after all the contours have been compared the best look like contour for plate number will be chosen.
	
	![image](https://github.com/afifimran/PlateLoc/assets/96810907/905b95b8-4755-4522-afca-4876b3b2e1e5)



	
# CONCLUSIONS

In this project, we wanted to create a useful image processing and licence plate localization programme. The objective of licence plate localization is to precisely and quickly locate the licence plate in an image so that the licence plate number may be recovered and the image processed further. For applications like automated toll collection, parking lot management, and traffic monitoring, this procedure is critical for locating and extracting licence plate regions from vehicle photos. Image acquisition, image enhancement, and final image processing processes comprise our three-part division of the image processing process. Using cameras and analog-to-digital converters, images were captured and digitally converted during the image acquisition process. Image enhancement is the process of altering an image to make it better suited for display or further analysis. This method helps to minimise noise and eliminate some interference components to create a more accurate image. Binarization, grayscale conversion, Gaussian smoothing, and edge detection were the last image processing procedures that prepared the licence plate image for processing and analysis. As for the outcomes, we were able to create a useful application that could find the licence plate number. In order to provide a more realistic image, our image enhancing techniques reduced noise and eliminated some interfering sources. Using numerous horizontal lines, we localised the licence plate on the dataset as well. The generalizations and rules that were drawn from the findings do, however, still include a few exceptions. The performance of the application needs to be improved, particularly under difficult settings like dim lighting, glare, and changing weather. Since image processing and licence plate localisation are crucial for many transportation-related applications, this research has many theoretical and practical ramifications. The work's conclusions include the value of image enhancement methods in enhancing the precision of licence plate localisation and the potential for additional study in this field. The performance of the programme in difficult settings can be improved by investigating more sophisticated image processing techniques and machine learning algorithms in future work.
