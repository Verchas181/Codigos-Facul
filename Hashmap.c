#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TABLE_SIZE 100

typedef struct Entry {
    char *key;
    int value;
    struct Entry *next;
} Entry;

typedef struct {
    Entry *entries[TABLE_SIZE];
} Hashmap;

unsigned int hash(const char *key) {
    unsigned int hash = 0;
    for (int i = 0; key[i] != '\0'; i++) {
        hash = 31 * hash + key[i];
    }
    return hash % TABLE_SIZE;
}

Hashmap *create_hashmap() {
    Hashmap *map = malloc(sizeof(Hashmap));
    for (int i = 0; i < TABLE_SIZE; i++) {
        map->entries[i] = NULL;
    }
    return map;
}

void put(Hashmap *map, const char *key, int value) {
    unsigned int index = hash(key);
    Entry *entry = map->entries[index];

    while (entry != NULL) {
        if (strcmp(entry->key, key) == 0) {
            entry->value = value;
            return;
        }
        entry = entry->next;
    }

    Entry *new_entry = malloc(sizeof(Entry));
    new_entry->key = strdup(key);
    new_entry->value = value;
    new_entry->next = map->entries[index];
    map->entries[index] = new_entry;
}

int get(Hashmap *map, const char *key) {
    unsigned int index = hash(key);
    Entry *entry = map->entries[index];

    while (entry != NULL) {
        if (strcmp(entry->key, key) == 0) {
            return entry->value;
        }
        entry = entry->next;
    }

    return -1; // Indica que a chave não foi encontrada
}
