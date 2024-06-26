function solution(n, m, section) {
    let wall = Array(n).fill(true);
    let count = 0;
    for(el of section){
        wall[el-1] = false;
    }
    while(wall.includes(false)){
        let start = wall.indexOf(false);
        wall = [...wall.slice(0,start), ...wall.slice(start,start+m).map(el => el = true), ...wall.slice(start+m)];
        count++;
    }
    return count;
}