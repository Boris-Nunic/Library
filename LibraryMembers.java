
import java.util.HashMap;
import java.util.Map;

public class LibraryMembers {

	private Map<Integer, Member> idToMember = new HashMap<>();
	
	public LibraryMembers() {
		
	}
	
	public Map<Integer, Member> getIdToMember (){
		return idToMember;
	}
	
	public void registerNewMember(Member newMember) {
		int id = newMember.getId();
		if (idToMember.containsKey(id)) {
			throw new IllegalArgumentException("The member with specified ID aready exists");
		}
		idToMember.put(id, newMember);
	}
	
	public void removeMember(int id) {
		if (!idToMember.containsKey(id)) {
			throw new IllegalArgumentException("The member with specified ID doesn't exist");
		}
		idToMember.remove(id);
	}
	
	public Member lookupById(int id) {
		return idToMember.get(id);
	}
	
	
}
