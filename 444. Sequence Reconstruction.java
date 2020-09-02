class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        HashMap<Integer, HashSet<Integer>> hash = new HashMap();
        HashMap<Integer, Integer> degree = new HashMap();
        for(List<Integer> seq : seqs) {
            if(seq.size() == 1) {
                degree.putIfAbsent(seq.get(0), 0);
                hash.putIfAbsent(seq.get(0), new HashSet());
            }
            else {
                for(int i = 0; i < seq.size() - 1; i++) {
                    degree.putIfAbsent(seq.get(i), 0);
                    hash.putIfAbsent(seq.get(i), new HashSet());
                    if(hash.get(seq.get(i)).contains(seq.get(i + 1))) {
                        continue;
                    }
                    hash.get(seq.get(i)).add(seq.get(i + 1));
                    degree.put(seq.get(i + 1), degree.getOrDefault(seq.get(i + 1), 0) + 1);
                }
            }
        }
        if(degree.size() != org.length) {
            return false;
        }
        List<Integer> result = new ArrayList();
        Queue<Integer> queue = new LinkedList();
        HashSet<Integer> visited = new HashSet();
        for(int key : degree.keySet()) {
            if(degree.get(key) == 0) {
                queue.offer(key);
            }
        }
        while(!queue.isEmpty()) {
            int len = queue.size();
            if(len > 1) {
                return false;
            }
            int cur = queue.poll();
            result.add(cur);
            if(!hash.containsKey(cur)) {
                continue;
            }
            for(int neighbor : hash.get(cur)) {
                degree.put(neighbor, degree.get(neighbor) - 1);
                if(degree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if(result.size() != org.length) {
            return false;
        }
        for(int i = 0; i < result.size(); i++) {
            if(result.get(i) != org[i]) {
                return false;
            }
        }
        return true;
    }
}