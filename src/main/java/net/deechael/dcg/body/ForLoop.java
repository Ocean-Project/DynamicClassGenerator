package net.deechael.dcg.body;

import net.deechael.dcg.JExecutable;
import net.deechael.dcg.JGeneratable;
import net.deechael.dcg.Requirement;
import net.deechael.dcg.items.Var;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ForLoop implements Operation {

    private final String type;
    private final String varName;
    private final Var initialized;
    private final Requirement requirement;
    private final Var operation;

    private final JExecutable body;

    public ForLoop(Class<?> type, String varName, Var initialized, Requirement requirement, Var operation, JExecutable body) {
        this.type = type != null ? type.getName().replace("$", ".") : null;
        this.varName = varName;
        this.initialized = initialized;
        this.requirement = requirement;
        this.operation = operation;
        this.body = body;
    }

    public ForLoop(@Nullable JGeneratable type, @Nullable String varName, @Nullable Var initialized, @Nullable Requirement requirement, @Nullable Var operation, @NotNull JExecutable body) {
        this.type = type != null ? type.getName() : null;
        this.varName = varName;
        this.initialized = initialized;
        this.requirement = requirement;
        this.operation = operation;
        this.body = body;
    }

    @Override
    public String getString() {
        String first = "";
        if (type != null && varName != null && initialized != null) {
            first = type + " " + varName + " = " + initialized.varString();
        }
        return "for (" + first + "; " + (requirement != null ? requirement.getString() : "") + "; " + (operation != null ? operation.varString() : "") + ") {\n"
                + body.getString() + "\n"
                + "}";
    }

}
