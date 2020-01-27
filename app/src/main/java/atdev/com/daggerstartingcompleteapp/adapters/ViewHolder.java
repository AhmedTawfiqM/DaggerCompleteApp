package atdev.com.daggerstartingcompleteapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import atdev.com.daggerstartingcompleteapp.databinding.GithubRepoClass;
import atdev.com.daggerstartingcompleteapp.pojo.models.GithubRepo;

public class ViewHolder extends RecyclerView.ViewHolder {

     GithubRepoClass githubRepoClass;

    public ViewHolder(GithubRepoClass githubRepoClass) {
        super(githubRepoClass.getRoot());
    }

    public void bind(GithubRepo githubRepo) {

        this.githubRepoClass.setSingleRepo(githubRepo);
    }

    public GithubRepoClass getGithubRepoClass() {
        return this.githubRepoClass;
    }
}
