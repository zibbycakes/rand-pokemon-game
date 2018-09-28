import requests
import json

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