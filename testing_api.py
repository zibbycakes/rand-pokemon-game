import requests
import json
import math
import time

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
        pokemon_db[pokemon_id] = {
            # 'id':pokemon_id,
            'name': species['name'],
            'gen': gen
        }
        # pokemon_db['pokemon'][pokemon_id] = {'name': species['name'], 'gen': gen}
    gen += 1

# response = requests.get("https://pokeapi.co/api/v2/pokemon/")
# response_json = response.json()
# pokemon_total = response_json['count']
pokemon_total = 801
repeat = math.floor(pokemon_total/100)

current_place = 1

for r in range(1,repeat+1):
    for x in range((100*(r-1)+1), (100*r)+1):
        print(x)
        pkmn_no = x+1

        url = "https://pokeapi.co/api/v2/pokemon/"+str(pkmn_no)+"/"
        print(url)
        response = requests.get(url)
        
        response_json = response.json()

        pokemon_db[pkmn_no]['sprite'] = response_json['sprites']['front_default']
        types = response_json['types']

        pokemon_db[pkmn_no]['type'] = types[0]['type']['name']
        if(len(types) > 1):
            pokemon_db[pkmn_no]['type'] = pokemon_db[pkmn_no]['type'] + ", " + types[1]['type']['name']
        current_place += 1


    time.sleep(60)
for x in range(repeat*100, repeat*100+2):
    print(x)
    pkmn_no = x+1

    url = "https://pokeapi.co/api/v2/pokemon/"+str(pkmn_no)+"/"
    print(url)
    response = requests.get(url)
    
    response_json = response.json()

    pokemon_db[pkmn_no]['sprite'] = response_json['sprites']['front_default']
    types = response_json['types']

    pokemon_db[pkmn_no]['type'] = types[0]['type']['name']
    if(len(types) > 1):
        pokemon_db[pkmn_no]['type'] = pokemon_db[pkmn_no]['type'] + ", " + types[1]['type']['name']


# print(pokemon_db)
with open('pokemon_db.json', 'w') as outfile:
    json.dump(pokemon_db, outfile, indent=4)
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
