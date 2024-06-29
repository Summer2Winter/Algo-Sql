const solution = (distance, rocks, n) => {
    rocks.push(0);
    rocks.push(distance);
    rocks.sort((a, b) => a - b);
    const dist = [];
    for (let i = 1; i < rocks.length; i++) {
      dist.push(rocks[i] - rocks[i - 1]);
    }
    let max = distance;
    let min = 0;
    let ans = 0;
    while (min <= max) {
      const mid = Math.floor((max + min) / 2);
      let acc = 0;
      let cnt = 0;
      for (const value of dist) {
        if (value + acc < mid) {
          acc += value;
          cnt++;
        } else acc = 0;
      }
      if (cnt > n) max = mid - 1;
      else {
        min = mid + 1;
        ans = mid;
      }
    }
    return ans;
  };