from bs4 import BeautifulSoup
path="C:\\Users\\User\\capstone\\index.html" 
f = open(path, "r")
soup = BeautifulSoup(f, 'html.parser')
for link in soup.find_all('a'):
    print(link.get('href'))