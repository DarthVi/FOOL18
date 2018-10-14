push 0
push function1
push 0
push classA
new
lfp
push -3
lfp
add
lw
copy
lw
push 0
add
lc
js
lfp
push 5
lfp
push -2
lfp
add
lw
js
add
halt

function0:
cfp
lra
push -10
srv
sra
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 0
push 1
lfp
add
lw
sub 
srv
sra
pop
pop
sfp
lrv
lra
js
classA:
function0
classnull:
