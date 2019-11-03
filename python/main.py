import requests
r = requests.get('https://api.ipify.org?format=json')
print(r.content)
