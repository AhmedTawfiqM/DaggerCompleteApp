package atdev.com.daggerstartingcompleteapp.pojo.components.networkcomponent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface NetworkComponentScope {
}


// This SCope make objects are created one only for all using