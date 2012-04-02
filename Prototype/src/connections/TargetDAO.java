package connections;

public interface TargetDAO extends DAO
{
	public boolean applyBusinessRule(String _code);
}
