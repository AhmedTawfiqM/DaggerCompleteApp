package atdev.com.daggerstartingcompleteapp.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import atdev.com.daggerstartingcompleteapp.R;
import atdev.com.daggerstartingcompleteapp.databinding.GithubRepoClass;
import atdev.com.daggerstartingcompleteapp.pojo.models.GithubRepo;
import atdev.com.daggerstartingcompleteapp.utilities.AeticleListener;

public class ReposAdapter extends RecyclerView.Adapter<ViewHolder> {

    GithubRepoClass githubRepoClass;
    List<GithubRepo> repos;

    //@Inject
    Context context;

    public ReposAdapter(Context context, Picasso picasso) {

        this.context = context;
    }

    public void SetRepos(List<GithubRepo> repos) {
        this.repos = repos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        githubRepoClass = DataBindingUtil.inflate(inflater, R.layout.single_row, viewGroup, false);

        return new ViewHolder(githubRepoClass);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final GithubRepo repo = repos.get(i);

        viewHolder.bind(repo);

        final GithubRepoClass githubRepo = viewHolder.getGithubRepoClass();

        githubRepo.setListner(new AeticleListener() {
            @Override
            public void onRowClick() {

                Toast.makeText(context, repo.description, Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }
}
