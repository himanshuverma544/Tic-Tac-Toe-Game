# How to put project on remote from local:-

1. Create a git repository on github where you will put your project.

2. On your local go to your project folder and initialize it with "***git init***" command.

3. Then, type "***git status***" command to see the untracked files (in red colour) or the files that are not in staging area.

4. Enter "***git add .***" or "***git add directory-name***" or "***git add file-name with path***" to add the files to staging area.

5. Enter "git status" to check the tracked files(in green colour).

6. Commit your code using "git commit -m 'your message'" command. Use add, update or delete in your message.

7. Now, add the URL for the remote repository where your local repository will be pushed. Use "***git remote add origin-name remote-URL*****".

8. Now, if you wish to verifiy the new remote URL then use "***git remote -v***" command.
Note: You have to set the remote url once only.

9. Now, push the changes from your local repository to remote repository using "***git push -u origin-name branch-name***".

10. Put the username and password.(Only Once) That's it.

* In windows, it keeps on asking username and password again and again. To stop that put "***git config credential.helper store***" command. It will doesn't ask you then.


# How to put project on local from remote:-

1. Create a folder in your local where you will have your repository. Go inside that folder.

2. Use "***git clone remote-URL***" command to have your repository.

3. If there is a change in remote repository then to reflect that change in your local repository use "***git pull origin-name branch-name***" command.

* If there is a change in remote file and also in the local file then before pushing, pull the repository and resolve the conflict(if any) and then push.


# Branching:-

1. "***git checkout -b branch-name***" - Make a new branch locally and switch to it.

2. "***git branch branch-name***" - Make a new branch with the given name.

Note: The branches we create, will already have the files that were already present in our current branch. Example, if we are in master branch and we are created the branch feature. Then, feature branch will have the files already that master branch have.

3. "***git checkout branch-name***" - Switch to given branch.

4. "***git branch***" - Shows the branches we have.

5. "***git merge branch-name***" - Merge the present branch with the given branch name. We need to merge from the branch which doesn't have thelatest commit.

To do a merge (locally), git checkout the branch you want to merge INTO. Then type git merge **branch** where **branch** is the branch you want to merge FROM.

Note: Remember to reflect all of the above changes on remote repository(github) you need to push after the command. 

6. "***git branch -d branch-name***" - Delete the given branch locally. But, still we can checkout on deleted branch and make it alive again.

7. "***git push origin-name --delete branch-name***" - Delete the given branch from github.

* If we clone a repository that have branches from github to our local folder. Then, initially it will not show any branches locally.

To show them we need to checkout to the branches that are on github and then they will become visible.

* If we need to upload local repository which have branches on github. Then, we need to simply push the local repository branch by branch. Then, it will show on github with branches.



# Utilities:-

1. "***git diff file-name or branch-name"*** - Shows what difference we had made in the given file.

2. "***git log***" - Shows all the commits.

3. "***git log -5***" - Shows the last 5 commits.

4. "***git show commit-hash***" - Shows what we had done in that particular commit.

5. "***git restore file-name***" - Removes your file from unstaging area as well revert back the changes in the file.

6. "***git restore --staged file-name***" - Removes your file from staging area, your file will be now in unstaging area. Doesn't revert back the changes in the file.

7. "***git reset --soft head^***" - Undo your last commit. But does not revert back the changes in the file.

8. "***git reset --hard head^***" - Undo your last commit as well revert back the changes in the file.

9. "***git reset --hard master@{"10 minutes ago"}***" - Alternatively, reset to a particular point in time.

10. "***git reset --hard branch-name***" - Resets your current branch to given name branch.

11. "***git reset --hard commid-Id***" - Resets and took your commit head to the entered commit-id.

12. "***git revert commit-hash***" - Revert your particular commit means undo the changes that happened in that particular commit.

13. "***git push --force origin branch-name***" - To push with force, use with caution.

14. "***git reset --keep HEAD@{1}***" - Undo last pull.

15. "***git pull --rebase***" - Use it when you commit before taking pull and a merge commit generates. So, to keep git free of merge commits use this command.

16. "***git remote set-url origin name url***" - Use it when your git url got changed some how.

# Useful Links:-

1. Git Tutorial - 
* https://guides.github.com/introduction/git-handbook/ 

2. .gitignore - 
* https://www.pluralsight.com/guides/how-to-use-gitignore-file

3. Undo a particular commit in git thats been pushed to remote repos - 
* https://stackoverflow.com/questions/2318777/undo-a-particular-commit-in-git-thats-been-pushed-to-remote-repos

4. All about reverting and reseting a commit - 
* https://stackoverflow.com/questions/4114095/how-do-i-revert-a-git-repository-to-a-previous-commit

5. Git Rebase -
*  https://www.youtube.com/watch?v=f1wnYdLEpgI 
*  https://kernowsoul.com/blog/2012/06/20/4-ways-to-avoid-merge-commits-in-git/
 
6. Undo last pull - 
* https://stackoverflow.com/questions/5815448/how-to-undo-a-git-pull/5815626

7. Configure your 'user.name' and 'user.email' in git - 
* https://www.codegrepper.com/code-examples/shell/vscode+make+sure+you+configure+your+%27user.name%27+and+%27user.email%27+in+git
    
8. How to create token in github - 
* https://stackoverflow.com/questions/68775869/support-for-password-authentication-was-removed-please-use-a-personal-access-to    
