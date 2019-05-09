package projects.riteh.post_itpin_it.view;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import projects.riteh.post_itpin_it.controller.PostAdapter;
import projects.riteh.post_itpin_it.model.Post;

import java.util.List;

@SuppressLint("ValidFragment")
public class Tab2Fragment extends PostFragments {
    private PostAdapter postAdapter;

    Tab2Fragment(int layoutID) {
        super(layoutID);
    }

    @Override
    protected void setAdapterView() {
        postAdapter = new PostAdapter(getActivity(), mPostsViewModel, (MainActivity)getActivity(), false);
        recyclerView.setAdapter(postAdapter);
        // Here we define how we want to display post-its in the fragment (either linearly as rows or something else)
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        mPostsViewModel.getAllUnpinned().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(@Nullable List<Post> posts) {
                postAdapter.setPosts(posts);
            }
        });
    }
}
