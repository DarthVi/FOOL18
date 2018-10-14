push 0
push function3
lfp
push 9
push 1
push classA
new
push 1
push classB
new
lfp
push -2
lfp
add
lw
js
halt

function0:
cfp
lra
push 1
push 0
lfp
add
lw
calchoff
add
lw
push 5
sub
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
lfp
push 1
lfp
lw
add
lw
copy
lw
push 0
add
lc
js
srv
sra
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 100000
srv
sra
pop
sfp
lrv
lra
js

function3:
cfp
lra
push 1
lfp
push 1
lfp
add
lw
copy
lw
push 0
add
lc
js
srv
pop
sra
pop
pop
sfp
lrv
lra
js
classA:
function0
classB:
function1
function2
classnull:
