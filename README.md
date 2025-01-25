<p align="center">
    <img src="https://raw.githubusercontent.com/firefly-iii/firefly-iii/develop/.github/assets/img/logo-small.png" align="center" width="30%">
</p>
<p align="center"><h1 align="center">Firefly III Testing Repository Automation Project
</h1></p>
<p align="center">
	<em>Empowering Secure Financial Transfers with Robust Testing</em>
</p>
<p align="center">
	<img src="https://img.shields.io/github/last-commit/Ameerm98/FireflyIIITesting?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/Ameerm98/FireflyIIITesting?style=default&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/Ameerm98/FireflyIIITesting?style=default&color=0080ff" alt="repo-language-count">
</p>
<p align="center"><!-- default option, no dependency badges. -->
</p>
<p align="center">
	<!-- default option, no dependency badges. -->
</p>
<br>

---

##  Overview

FireflyIIITesting is an open-source project designed to streamline and secure financial transactions. It offers robust features such as creating, editing, and deleting transfers, managing user accounts, and categorizing transactions. The project also emphasizes security with JWT authentication and automated UI testing. Ideal for financial tech developers and users seeking a reliable, user-friendly platform for managing their finances.

---

##  Project Structure

```sh
└── FireflyIIITesting/
    ├── .github
    │   └── workflows
    ├── docker-compose.yml
    ├── edits
    ├── pom.xml
    ├── src
    │   ├── main
    │   └── test
    ├── token
    └── unnamed.patch
```


###  Project Index
<details open>
	<summary><b><code>FIREFLYIIITESTING/</code></b></summary>
	<details> <!-- __root__ Submodule -->
		<summary><b>__root__</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/edits'>edits</a></b></td>
				<td>- TransferCreate, located in the 'edits' path, is a crucial component of the project, enabling the creation of financial transfers<br>- It interacts with the user interface, allowing users to input details such as description, source, destination, amount, budget, piggy bank, and bill<br>- This class significantly contributes to the project's functionality by facilitating financial transactions.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/token'>token</a></b></td>
				<td>- The 'token' file serves as a key component in the project's security infrastructure, containing a JWT (JSON Web Token)<br>- This token is used for authentication and secure data exchange between different parts of the application<br>- It contributes to the overall robustness and security of the codebase.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/unnamed.patch'>unnamed.patch</a></b></td>
				<td>- The provided patch file introduces two new files to the project: `.db.env` and `.env`<br>- The `.db.env` file is a configuration file for a MySQL database<br>- It sets up a random root password, specifies a user named 'firefly', assigns a password to this user, and creates a database also named 'firefly'<br>- This file is crucial for the setup and security of the database in the project.

The `.env` file, while its content is not fully shown, is typically used to store environment variables<br>- These variables can include API keys, database credentials, or any other configuration options that the application might need to run properly<br>- This file is essential for the project as it provides a way to inject environment-specific configuration into the application in a secure manner.

Together, these files contribute to the overall architecture of the project by providing a secure and efficient way to manage configuration options and database setup.</td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/docker-compose.yml'>docker-compose.yml</a></b></td>
				<td>- The docker-compose.yml orchestrates the deployment of the Firefly III core application, its MariaDB database, and a cron service for scheduled tasks<br>- It ensures these services are networked together, restarts them if they fail, and manages their storage and environment variables<br>- This file is crucial for the application's containerized deployment and operation.</td>
			</tr>
			</table>
		</blockquote>
	</details>
	<details> <!-- .github Submodule -->
		<summary><b>.github</b></summary>
		<blockquote>
			<details>
				<summary><b>workflows</b></summary>
				<blockquote>
					<table>
					<tr>
						<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/.github/workflows/TransferCreateUITesting.yaml'>TransferCreateUITesting.yaml</a></b></td>
						<td>- The TransferCreateUITesting.yaml in the .github/workflows directory orchestrates UI testing for the transfer creation feature<br>- It sets up automated tests on both Chrome and Firefox browsers, using Selenium Grid for test execution<br>- The tests are triggered manually and can be run on any specified grid, including local environments.</td>
					</tr>
					<tr>
						<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/.github/workflows/LoginPageUITesting.yaml'>LoginPageUITesting.yaml</a></b></td>
						<td>- LoginPageUITesting.yaml orchestrates UI testing for the login page of the application<br>- It sets up testing environments for both Chrome and Firefox browsers on an Ubuntu system, runs the tests, and then tears down the environments<br>- The tests are executed on a specified grid, which can be local or remote, ensuring the login page's compatibility and functionality across different browser versions.</td>
					</tr>
					<tr>
						<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/.github/workflows/TransfersGetAPITesting.yaml'>TransfersGetAPITesting.yaml</a></b></td>
						<td>- TransfersGetAPITesting.yaml orchestrates automated testing for the Transfers Get API<br>- It sets up testing environments on both Chrome and Firefox browsers, running on an Ubuntu system<br>- The tests are executed on a specified grid, with the ability to run locally as a default<br>- After testing, it ensures the grid is properly shut down.</td>
					</tr>
					<tr>
						<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/.github/workflows/smokeTests.yaml'>smokeTests.yaml</a></b></td>
						<td>- Smoke Tests, located in the GitHub workflows directory, orchestrates a series of automated tests on a specified grid<br>- It sets up a testing environment, runs tests for login, transfer creation, and transfer editing functionalities, and then tears down the grid<br>- The tests are designed to run on Chrome version 131.0, with the ability to specify a different grid URL.</td>
					</tr>
					<tr>
						<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/.github/workflows/TranferEditUITesting.yaml'>TranferEditUITesting.yaml</a></b></td>
						<td>- The TransferEditUITesting.yaml in the .github/workflows directory is a GitHub Actions workflow that automates UI testing for the Transfer Edit feature<br>- It supports testing on both Chrome and Firefox browsers, and allows for tests to be run on a specified grid URL<br>- The workflow also manages the setup and teardown of the testing environment.</td>
					</tr>
					<tr>
						<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/.github/workflows/TransferDeleteAPITesting.yaml'>TransferDeleteAPITesting.yaml</a></b></td>
						<td>- TransferDeleteAPITesting.yaml orchestrates automated testing for the Transfer Delete API<br>- It sets up testing environments on both Chrome and Firefox browsers, running on an Ubuntu system<br>- The tests are executed on a specified grid URL, with the ability to run locally by default<br>- Post-testing, it ensures the teardown of the grid to maintain a clean testing environment.</td>
					</tr>
					</table>
				</blockquote>
			</details>
		</blockquote>
	</details>
	<details> <!-- src Submodule -->
		<summary><b>src</b></summary>
		<blockquote>
			<details>
				<summary><b>main</b></summary>
				<blockquote>
					<details>
						<summary><b>java</b></summary>
						<blockquote>
							<details>
								<summary><b>org</b></summary>
								<blockquote>
									<details>
										<summary><b>example</b></summary>
										<blockquote>
											<table>
											<tr>
												<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/main/java/org/example/CategoryCreatePage.java'>CategoryCreatePage.java</a></b></td>
												<td>- CategoryCreatePage, located in the src/main/java/org/example directory, is a Java class that facilitates the creation of new categories in a web application<br>- It interacts with the web driver to input the category name and submit the form, thereby adding a new category to the system.</td>
											</tr>
											<tr>
												<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/main/java/org/example/LoginPage.java'>LoginPage.java</a></b></td>
												<td>- LoginPage.java serves as the entry point for user authentication in the application<br>- It provides functionality for user login, both valid and invalid, and password reset<br>- It also handles the loading of the login page and ensures its successful display<br>- This class is crucial for maintaining secure user access and navigation to the home page or password reset page.</td>
											</tr>
											<tr>
												<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/main/java/org/example/Account.java'>Account.java</a></b></td>
												<td>- Account.java serves as a key component in the project's codebase, enabling the creation and management of user accounts<br>- It interacts with the web interface, allowing users to navigate to the homepage, create accounts, and verify account creation<br>- This class is integral to the user experience and data management within the application.</td>
											</tr>
											<tr>
												<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/main/java/org/example/TransferCreatePage.java'>TransferCreatePage.java</a></b></td>
												<td>- TransferCreatePage serves as a key component in the application's financial transaction functionality<br>- It provides an interface for creating transfers between accounts, including the ability to specify details such as the source, destination, amount, date, and description<br>- The class also supports adding notes and categories to transfers, and validates whether a transfer was successfully created.</td>
											</tr>
											<tr>
												<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/main/java/org/example/TransferInformation.java'>TransferInformation.java</a></b></td>
												<td>- TransferInformation serves as a key component in the project's architecture, enabling the extraction of specific transfer details from a web page using Selenium WebDriver<br>- It retrieves information such as description, date, source and destination accounts, amount, category, and notes<br>- Additionally, it verifies the success of transfer edits.</td>
											</tr>
											<tr>
												<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/main/java/org/example/Main.java'>Main.java</a></b></td>
												<td>- Main.java, located in the src/main/java/org/example directory, serves as the entry point of the application<br>- It greets the user and executes a loop that prints the numbers 1 through 5<br>- This functionality contributes to the overall codebase by initiating the program's operations.</td>
											</tr>
											<tr>
												<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/main/java/org/example/BillCreate.java'>BillCreate.java</a></b></td>
												<td>- BillCreate in the org.example package facilitates the creation of new bills in the application<br>- It interacts with the user interface, allowing users to input bill details such as name, minimum and maximum amounts, and start and end dates<br>- It also verifies the successful creation of a bill.</td>
											</tr>
											<tr>
												<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/main/java/org/example/Transfers.java'>Transfers.java</a></b></td>
												<td>- Transfers.java, located in the src/main/java/org/example directory, facilitates the selection of specific transfers in a web application<br>- It waits for the page to load, identifies the desired transfer, initiates an edit operation, and navigates to the TransferEditPage<br>- This is crucial for managing transfer operations within the application.</td>
											</tr>
											<tr>
												<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/main/java/org/example/HomePage.java'>HomePage.java</a></b></td>
												<td>- HomePage.java serves as a central interface for the application's home page, enabling navigation and interaction with various elements such as accounts, categories, and transfers<br>- It also manages the creation and deletion of accounts, ensuring seamless user experience and efficient data management within the application.</td>
											</tr>
											<tr>
												<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/main/java/org/example/ResetPasswordPage.java'>ResetPasswordPage.java</a></b></td>
												<td>- ResetPasswordPage in the org.example package facilitates the password reset process<br>- It interacts with the WebDriver to locate and manipulate the email input field and reset button on the webpage<br>- It also retrieves success messages post submission, contributing to the user authentication functionality of the codebase.</td>
											</tr>
											<tr>
												<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/main/java/org/example/DriverFactory.java'>DriverFactory.java</a></b></td>
												<td>- DriverFactory serves as a central point for creating WebDriver instances in the project<br>- It supports both local and remote WebDriver creation, with the ability to handle Chrome and Firefox browsers<br>- The choice of browser and whether to use a remote WebDriver is determined by environment variables<br>- This flexibility aids in testing across different environments and browsers.</td>
											</tr>
											<tr>
												<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/main/java/org/example/TransferEditPage.java'>TransferEditPage.java</a></b></td>
												<td>- TransferEditPage in the src/main/java/org/example directory serves as an interface for editing transfer details in a web application<br>- It provides methods to select accounts, input transfer amount, date, description, category, and notes<br>- After editing, it submits the changes and returns a TransferInformation object, encapsulating the updated transfer details.</td>
											</tr>
											</table>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
			<details>
				<summary><b>test</b></summary>
				<blockquote>
					<details>
						<summary><b>java</b></summary>
						<blockquote>
							<details>
								<summary><b>selenium</b></summary>
								<blockquote>
									<table>
									<tr>
										<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/test/java/selenium/TransferCreateTest.java'>TransferCreateTest.java</a></b></td>
										<td>- TransferCreateTest is a test suite for validating the functionality of money transfers in a banking application<br>- It verifies various scenarios such as creating valid transfers, handling empty transfers, and managing transfers with missing or non-existent accounts<br>- It also tests the categorization of transfers and the addition of notes to transfers<br>- After each test, it cleans up by deleting created accounts.</td>
									</tr>
									<tr>
										<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/test/java/selenium/LoginPageTest.java'>LoginPageTest.java</a></b></td>
										<td>- LoginPageTest, located in the test directory, validates the functionality of the login page in the application<br>- It conducts tests for valid and invalid login scenarios, and password reset functionality<br>- The results of these tests contribute to ensuring the robustness and reliability of the user authentication process in the application.</td>
									</tr>
									<tr>
										<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/test/java/selenium/TransferEditTest.java'>TransferEditTest.java</a></b></td>
										<td>- TransferEditTest, located in the test directory, is a critical component of the project's testing suite<br>- It validates the functionality of editing various fields in a transfer, such as the description, amount, and notes<br>- The tests ensure that changes are successfully saved and accurately reflected in the system, contributing to the overall robustness and reliability of the application.</td>
									</tr>
									</table>
								</blockquote>
							</details>
							<details>
								<summary><b>API</b></summary>
								<blockquote>
									<table>
									<tr>
										<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/test/java/API/TransferDeleteAPITest.java'>TransferDeleteAPITest.java</a></b></td>
										<td>- TransferDeleteAPITest, located in the test directory, validates the functionality of the API endpoints responsible for deleting transfers<br>- It includes tests for both valid and non-existent transfers, ensuring the API responds with appropriate status codes<br>- This contributes to the robustness and reliability of the overall application.</td>
									</tr>
									<tr>
										<td><b><a href='https://github.com/Ameerm98/FireflyIIITesting/blob/master/src/test/java/API/TransfersGetAPITest.java'>TransfersGetAPITest.java</a></b></td>
										<td>- TransfersGetAPITest, located in the test directory, is a Java test class for validating the functionality of the 'transfers' API endpoint<br>- It primarily ensures that the API correctly responds to GET requests for all transfers, returning a successful HTTP status code<br>- The test uses a personal token for authorization.</td>
									</tr>
									</table>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
</details>

---
##  Getting Started

###  Prerequisites

Before getting started with FireflyIIITesting, ensure your runtime environment meets the following requirements:

- **IDE:** Intellij(Java)
- **Container Runtime:** Docker


###  Installation

Install FireflyIIITesting using one of the following methods:

**Build from source:**

1. Clone the FireflyIIITesting repository:
```sh
❯ git clone https://github.com/Ameerm98/FireflyIIITesting
```

2. Navigate to the project directory:
```sh
❯ cd FireflyIIITesting
```

3. Install the project dependencies:


**Using `docker`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Docker-2CA5E0.svg?style={badge_style}&logo=docker&logoColor=white" />](https://www.docker.com/)

```sh
❯ docker build -t Ameerm98/FireflyIIITesting .
```




###  Usage
Run FireflyIIITesting using the following command:
**Using `docker`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Docker-2CA5E0.svg?style={badge_style}&logo=docker&logoColor=white" />](https://www.docker.com/)

```sh
❯ docker run -it {image_name}
```


### Testing Objectives
The primary objective of these tests is to ensure the quality and reliability of Firefly III critical features by executing automated UI testing and API Testing 
![image](https://github.com/user-attachments/assets/448faa3c-c133-49ec-ac20-660c598a45cd)



### Features Tested

UI:-
- Transfer Create
- Transfer Edit

API Endpoints :-
- DELETE Transfer 
- GET All Transfers

### Testing Design

UI:-
- Selenium
- Pom(Page Object Model)
- Junit
  
API:-
- Rest Assured
- Junit

### Running Tests:-
(Make sure baseURL updated according to the running environment)

Locally:-
- Mvn(command use example:- mvn test)

Remote:-
- use ngrok
- Update APP_URL variable in docker-compose.yml file
- run again the docker command to recreate the images
- Run in Github Actions ,Manual Trigger()


---
<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/Ameerm98/FireflyIIITesting
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="left">
   <a href="https://github.com{/Ameerm98/FireflyIIITesting/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=Ameerm98/FireflyIIITesting">
   </a>
</p>
</details>

