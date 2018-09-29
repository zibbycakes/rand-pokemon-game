import requests
import json

gen = 1
pokemon_db = {}
while gen < 8:
    response = requests.get("https://pokeapi.co/api/v2/generation/"+str(gen))
    # print(response.status_code)
    response_json = response.json()
    # print('gen ', gen)
    # print(response_json['pokemon_species'])
    for species in response_json['pokemon_species']:
        poke_url = species['url']
        pokemon_id = int(poke_url[poke_url.find('-species/')+9:len(poke_url)-1])
        # print(pokemon_id)
        pokemon_db[pokemon_id] = {'name': species['name'], 'gen': gen}
    gen += 1

# print(pokemon_db)
'''
# testing statements

print(pokemon_db[25])
print(pokemon_db[123])
print(pokemon_db[239]) # elekid
print(pokemon_db[291]) # ninjask
print(pokemon_db[432]) # purugly
print(pokemon_db[527]) # woobat
print(pokemon_db[700]) # sylveon
print(pokemon_db[758]) # salazzle
'''

'''
response = requests.get("https://pokeapi.co/api/v2/generation/1/")
print(response.status_code)

response_json = response.json()
print(response_json['pokemon_species'])

pokemon_db_a =  {} # { id: name }

for species in response_json['pokemon_species'] :
    poke_url = species['url']
    pokemon_id = int(poke_url[poke_url.find('-species/')+9:len(poke_url)-1])
    # print(pokemon_id)
    pokemon_db_a[pokemon_id] = {'name': species['name'], 'gen': '1'}

print(pokemon_db_a)
print(pokemon_db_a[99])
'''
