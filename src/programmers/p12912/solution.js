function solution(a, b) {
    let sum = 0;
    let small = Math.min(a,b);
    let big = Math.max(a,b);

    for (small; small <= big; small++){
        sum += small;
    }
    return sum;
}