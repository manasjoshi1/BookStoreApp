
<h3 align="center">BookStore App </h3>

  <p align="center">
    project_description
    <br />
    <a href="https://github.com/manasjoshi1/BookStoreApp"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/manasjoshi1/BookStoreApp">View Demo</a>
    ·
    <a href="https://github.com/manasjoshi1/BookStoreApp/issues">Report Bug</a>
    ·
    <a href="https://github.com/manasjoshi1/BookStoreApp/issues">Request Feature</a>
  </p>




<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#future-scope">Future Scope</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This project is a basic CRUD application with admin panel. The project provides the facilities of managaing the book inventory and seggregating them into different categories to the admin level user. A customer can sign up and start purchasing the books. The stock gets automatically updated into the inventory. Also, with the Spring Security framework user cannot traverse the admin section.




### Built With

* [Spring Boot]()
* [Thymeleaf]()
* [MySQL]()
* [log4j]()
* [Bootstrap]()




<!-- GETTING STARTED -->
## Getting Started


### Prerequisites

Make sure you have the following applications installed ono your machine
* Eclipse / Intellij IDE
* MySQL Server
* Web Browser
* Make sure you have an active internet connection so that maven can fetch the dependencies.

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/manasjoshi1/BookStoreApp.git
   ```
2. Import the project into IDE
3. Open application.properties file
  ```sh
  /BookStoreApp/src/main/resources/application.properties
  ```
3. Configure the port, username,password, and database name properties as per your MySQL
4. Run the application as spring boot application
5. Open your MySQL and verify whether the columns are created or not.
6. If all goes well then run the queries inside admin queries from the file queries.txt
7. Now open
  ```sh
  localhost:8080/admin
  ```
And login with the credentials username: admin@gmail.com and paassword : 123456



<!-- USAGE EXAMPLES -->

## Usage
### Database 
![Product Name Screen Shot][DataBase-screenshot]


### Login
![Product Name Screen Shot][Login-screenshot]
### Register
![Product Name Screen Shot][Register-screenshot]

### Admin
![Product Name Screen Shot][adminPanel-screenshot]

#### Manage Categories
![Product Name Screen Shot][adminCategory-screenshot]

#### Manage Books
![Product Name Screen Shot][adminBooks-screenshot]

### Customer

#### Shop
![Product Name Screen Shot][Shop-screenshot]

#### View Book
![Product Name Screen Shot][viewBook-screenshot]



<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/manasjoshi1/BookStoreApp/issues) for a list of proposed features (and known issues).



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Future Scope
* Showing a success page after the successful purchase of book.
* Adding a cart feature so that multiple books can be purchased at once.
* Payment Gateway
* User can see the past orders
* A dash board where admin can see the most sold books

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

Your Name - [Manas Joshi](mailto:joshimanassunil@gmail.com)

Project Link: [https://github.com/manasjoshi1/BookStoreApp](https://github.com/manasjoshi1/BookStoreApp)




[adminBooks-screenshot]: images/adminBooks.png
[adminPanel-screenshot]: images/adminPanel.png
[adminCategory-screenshot]: images/adminCategory.png
[Login-screenshot]: images/Login.png
[Register-screenshot]: images/Register.png
[viewBook-screenshot]: images/viewBook.png
[Shop-screenshot]: images/Shop.png
[DataBase-screenshot]: images/DataBase.png