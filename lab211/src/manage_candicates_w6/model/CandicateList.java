//package manage_candicates_w6.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CandicateList {
//    private List<Candicate> candidates;
//
//    public CandicateList(List<Candicate> candidates) {
//        this.candidates = candidates;
//    }
//
//    public void addCandidate(Candicate candidate) {
//        candidates.add(candidate);
//    }
//
//    public List<Candicate> getCandidatesByType(int type) {
//        List<Candicate> result = new ArrayList<>();
//        for (Candicate candidate : candidates) {
//            if (type == 0 && candidate instanceof Experience) {
//                result.add(candidate);
//            } else if (type == 1 && candidate instanceof Fresher) {
//                result.add(candidate);
//            } else if (type == 2 && candidate instanceof Intern) {
//                result.add(candidate);
//            }
//        }
//        return result;
//    }
//
//    public List<Candicate> searchCandidates(String name, int type) {
//        List<Candicate> foundCandidates = new ArrayList<>();
//        for (Candicate candidate : candidates) {
//            if (candidate.getFullName().toLowerCase().contains(name.toLowerCase()) && isCandidateOfType(candidate, type)) {
//                foundCandidates.add(candidate);
//            }
//        }
//        return foundCandidates;
//    }
//
//
//    private boolean isCandidateOfType(Candicate candidate, int type) {
//        switch (type) {
//            case 0:
//                return candidate instanceof Experience;
//            case 1:
//                return candidate instanceof Fresher;
//            case 2:
//                return candidate instanceof Intern;
//            default:
//                return false;
//        }
//    }
//
//    public List<Candicate> getAllCandidates() {
//        return candidates;
//    }
//}
