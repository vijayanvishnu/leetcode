


typedef struct {
    int *bits[100001];
    int size;
    int oneCount;
    int zeroCount;
} Bitset;
int one = 1;
int zero = 0;

Bitset* bitsetCreate(int size) {
    Bitset *ans = malloc(sizeof(Bitset));
    ans->size = size;
    ans->zeroCount = size;
    for(int i = 0; i < size ; i++){
        ans->bits[i] = &zero;
    }
    return ans;
}

void bitsetFix(Bitset* obj, int idx) {
    if(*(obj->bits[idx]) != 1){
        obj->oneCount++;
        obj->zeroCount--;
    }
    obj->bits[idx] = one == 1 ? &one : &zero;
}

void bitsetUnfix(Bitset* obj, int idx) {
    if(*(obj->bits[idx]) != 0){
        obj->oneCount--;
        obj->zeroCount++;
    }
    obj->bits[idx] = one == 0 ? &one : &zero;
}

void bitsetFlip(Bitset* obj) {
    int t = obj->oneCount;
    obj->oneCount = obj->zeroCount;
    obj->zeroCount = t;
    t = zero;
    zero = one;
    one = t;
}

bool bitsetAll(Bitset* obj) {
    return obj->size == obj->oneCount;
}

bool bitsetOne(Bitset* obj) {
    return obj->oneCount >= 1;
}

int bitsetCount(Bitset* obj) {
    return obj->oneCount;
}

char* bitsetToString(Bitset* obj) {
    char *res= calloc(obj->size +  1,sizeof(char));
    for(int i = 0; i < obj->size ; i++){
        res[i] = (*(obj->bits[i]) + '0');
    }
    res[obj->size] = 0;
    return res;
}

void bitsetFree(Bitset* obj) {
    zero = 0;
    one = 1;
    for(int i = 0 ; i < obj->size ; i++){
        obj->bits[i] = &zero;
    }
    obj->size = 0;
    obj->oneCount = 0;
    obj->zeroCount = 0;
}

/**
 * Your Bitset struct will be instantiated and called as such:
 * Bitset* obj = bitsetCreate(size);
 * bitsetFix(obj, idx);
 
 * bitsetUnfix(obj, idx);
 
 * bitsetFlip(obj);
 
 * bool param_4 = bitsetAll(obj);
 
 * bool param_5 = bitsetOne(obj);
 
 * int param_6 = bitsetCount(obj);
 
 * char* param_7 = bitsetToString(obj);
 
 * bitsetFree(obj);
*/