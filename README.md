# PasswordGeneratorAPI
A simple project to get a better hang of Java, which will be an API that provides access to generating a password dependent on the input parameters 

## Structure
passwordGenerator
  -src
    -main
      -java.com.example.passwordGenerator
        -controller
          PassControler
        -src
          AlpaphetbZ
          Generator
          Main
          Password
          PasswordAPI
          PasswordStrengthMeter
        PasswordGeneratorApplication

## Frameworks
The framework of choice for making the API is Spring 
Why?
1. No requirement for complex XML configurations.
2. Embedded Tomcat server to run Spring Boot applications
3. An auto-configuration feature by Spring Boot that configures your application automatically for certain dependencies.

## Password Generator 
### Handling API Request
Password Generator is very simple. It takes in parameters of the body of the request to the api, using Spring's @RequestBody
It then automatically assigns headers of the request to a handler class called GeneratorRequest
It then initializes Generator object using the getter methods of GeneratorRequest object and returns the password

### Generating a password
For generating the password, I used Alphabet to keep track of all elements allowed or desired to be used in the password. (e.g. upper letter, numbers etc.)
It then randomly selected characters at each index for desired lengths of a password.

### Password Strength Checker
The password strength checker uses two methods to compute the strength:
1. The simple checks to see if upper case, lower case etc are included
2. Entropy algorithm to check how predictable the actual password is
