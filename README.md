# Twitch Selenium Automation

A Selenium WebDriver-based automation framework for testing Twitch.tv functionality using Java, TestNG, and Page Object Model design pattern.

## 🎯 Project Overview

This project automates testing scenarios on Twitch.tv, specifically focusing on:
- Searching for content (e.g., "StarCraft II")
- Navigating through search results
- Clicking on video thumbnails
- Verifying successful navigation to video pages
- Taking screenshots for test evidence

## 🛠️ Technology Stack

- **Java 23** - Programming language
- **Selenium WebDriver 4.20.0** - Web automation framework
- **TestNG 7.4.0** - Testing framework
- **WebDriverManager 5.9.2** - Automatic WebDriver management
- **ExtentReports 5.1.2** - Test reporting
- **Maven** - Build and dependency management

## 📋 Prerequisites

- Java 23 or higher
- Maven 3.6+
- Chrome browser
- Internet connection

## 🚀 Setup Instructions

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd TwitchSelenium
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Run tests**
   ```bash
   # Run all tests
   mvn test
   
   # Run specific test suite
   mvn test -DsuiteXmlFile=src/testng/searchVideo.xml
   ```

## 📁 Project Structure

```
TwitchSelenium/
├── pom.xml                          # Maven configuration
├── src/
│   ├── main/java/
│   │   ├── pages/
│   │   │   └── HomePage.java        # Page Object for Twitch homepage
│   │   └── Helpers/                 # Helper classes
│   └── test/java/
│       ├── BaseTest.java            # Base test configuration
│       ├── VideoClickTest.java      # Test implementation
│       └── testng/
│           └── searchVideo.xml      # TestNG suite configuration
├── screenshots/                     # Test screenshots
└── target/                         # Compiled classes and reports
```

## 🧪 Test Scenarios

### Current Test: Video Search and Click
- **Test Name**: `videoClick()`
- **Description**: Searches for "StarCraft II" on Twitch and verifies successful video page navigation
- **Steps**:
  1. Navigate to Twitch.tv
  2. Click "Browse" button
  3. Search for "StarCraft II"
  4. Scroll through results
  5. Click on a video thumbnail
  6. Verify navigation to video page
  7. Take screenshot for evidence

## 🔧 Configuration

### Mobile Emulation
The framework is configured to run tests in mobile emulation mode (iPhone X) to ensure responsive design testing:
- Screen width: 390px
- Screen height: 844px
- Pixel ratio: 3.0

### Screenshots
- Screenshots are automatically captured after each test
- Stored in `./screenshots/` directory
- Filename format: `screenshot{timestamp}.png`

## 📊 Test Reports

Test execution reports are generated using:
- **TestNG** - Console and XML reports

## 🐛 Troubleshooting

### Common Issues

1. **ChromeDriver not found**
   - Solution: WebDriverManager automatically downloads the correct ChromeDriver version

2. **Element not found errors**
   - Check if Twitch website structure has changed
   - Verify internet connection
   - Ensure Chrome browser is up to date

3. **Mobile emulation issues**
   - Verify Chrome browser supports mobile emulation
   - Check Chrome version compatibility


Sample run GIF:
