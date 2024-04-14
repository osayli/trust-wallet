# Appium with Java for Trust Wallet App

This test suite is written using TestNG and is intended for Android automation.

## Test Cases

### Case 1: Wallet Creation Flow
- Close alert on launch
- Click on "Get Started"
- Click on "Create Wallet"
- Click on "Skip"
- Enter six digits to create passcode
- Confirm passcode
- Verify "Welcome Onboard" text

### Case 2: Need to Connect Wallet Flow
- Verify that the user cannot buy tokens without a wallet
    - Close alert on launch
    - Click on "Get Started"
    - Scroll ETH token when not connected to wallet
    - Click the buy icon
    - Verify the "Connect Wallet" text

