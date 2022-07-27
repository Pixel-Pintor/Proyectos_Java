package platform.repository;

import java.util.ArrayList;
import java.util.List;

public class CodeBaseRepository {

    static CodeBaseRepository instance = null;

    List<CodeBase> codeBaseList;

    private CodeBaseRepository() {
        this.codeBaseList = new ArrayList<>();
    }

    public static CodeBaseRepository getInstance() {
        if (instance == null) {
            instance = new CodeBaseRepository();
        }
        return instance;
    }

    public List<CodeBase> getCodeBaseList() {
        return this.codeBaseList;
    }
}