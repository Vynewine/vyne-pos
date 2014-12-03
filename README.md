# Vyne POS client for Android

- Open Vyne POS App
- Load Vyne POS page in a view
- Find out if user is logged in
- If user logs in for the first time from this device ask to select which warehouse he is from.
    - Need to send device info to the page loaded.
- After user is logged-in and warehouse is selected
  register device with Google GCM and send registration ID to the app.
- On the server maintain relationship between registration_ids and warehouses
  so that notifications can be send to appropriate device(s) for orders placed there.

- Register App with GCM
- Load Vyne POS page with registration_id in url
- User Logs-In and chooses Warehouse
- We tie warehouse to registration_id

